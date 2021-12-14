package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText title, content;
    Button addNote;
    private SharedPreferences.Editor editorTitles, editorContents;
    private SharedPreferences sharedpreferencesTitles;
    private SharedPreferences sharedpreferencesContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        sharedpreferencesTitles = getSharedPreferences("noteTitles", Context.MODE_PRIVATE);
        sharedpreferencesContents = getSharedPreferences("noteContents", Context.MODE_PRIVATE);
        editorTitles = sharedpreferencesTitles.edit();
        editorContents = sharedpreferencesContents.edit();

        title = findViewById(R.id.title_edit_text);
        content = findViewById(R.id.content_edit_text);
        addNote = findViewById(R.id.add_note_button);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (title.getText().length() == 0 && content.getText().length() == 0)
                    Toast.makeText(AddNoteActivity.this, "Title & Content are empty!", Toast.LENGTH_SHORT).show();
                else if (title.getText().length() == 0)
                    Toast.makeText(AddNoteActivity.this, "Title is empty!", Toast.LENGTH_SHORT).show();
                else if (content.getText().length() == 0)
                    Toast.makeText(AddNoteActivity.this, "Content is empty!", Toast.LENGTH_SHORT).show();
                else {

                    if (sharedpreferencesTitles.getString("title", null) == null &&
                            sharedpreferencesContents.getString("content", null) == null) {
                        editorTitles.putString("title", title.getText().toString() + ",");
                        editorContents.putString("content", content.getText().toString() + ",");
                    } else {
                        editorTitles.putString("title", sharedpreferencesTitles.getString("title", null)
                                + title.getText().toString() + ",");
                        editorContents.putString("content", sharedpreferencesContents.getString("content", null)
                                + content.getText().toString() + ",");
                    }
                    editorTitles.commit();
                    editorContents.commit();
                    Toast.makeText(AddNoteActivity.this, "Note Added Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}