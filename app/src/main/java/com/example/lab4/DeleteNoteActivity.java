package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class DeleteNoteActivity extends AppCompatActivity {

    private SharedPreferences sharedpreferencesTitles;
    private SharedPreferences sharedpreferencesContents;


    private ListView listView;
    private String title, content;
    private String[] titles, contents;
    private SharedPreferences.Editor editorTitles, editorContents;
    private MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        sharedpreferencesTitles = getSharedPreferences("noteTitles", Context.MODE_PRIVATE);
        sharedpreferencesContents = getSharedPreferences("noteContents", Context.MODE_PRIVATE);
        editorTitles = sharedpreferencesTitles.edit();
        editorContents = sharedpreferencesContents.edit();

        listView = (ListView) findViewById(R.id.list_view);

        title = sharedpreferencesTitles.getString("title", null);
        content = sharedpreferencesContents.getString("content", null);

        if (title != null) {
            titles = title.split(",");
            contents = content.split(",");
            adapter = new MyListAdapter(this, titles, contents);
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(DeleteNoteActivity.this)
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete this Note?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String replacedTitle = title.replace(titles[i] + ",", "");
                                String replacedContent = content.replace(contents[i] + ",", "");
                                titles = replacedTitle.split(",");
                                contents = replacedContent.split(",");

                                editorTitles.putString("title", replacedTitle);
                                editorContents.putString("content", replacedContent);
                                editorTitles.commit();
                                editorContents.commit();
                                Toast.makeText(DeleteNoteActivity.this, "Note Deleted Successfully!", Toast.LENGTH_SHORT).show();
                                adapter = new MyListAdapter(DeleteNoteActivity.this, titles, contents);
                                listView.setAdapter(adapter);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

    }
}