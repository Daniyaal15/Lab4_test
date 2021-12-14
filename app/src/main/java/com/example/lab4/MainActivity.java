package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String title, content;
    private String[] titles, contents;
    private boolean b;
    private MyListAdapter adapter;
    private SharedPreferences sharedpreferencesTitles;
    private SharedPreferences sharedpreferencesContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferencesTitles = getSharedPreferences("noteTitles", Context.MODE_PRIVATE);
        sharedpreferencesContent = getSharedPreferences("noteContents", Context.MODE_PRIVATE);
        title = sharedpreferencesTitles.getString("title", null);
        content = sharedpreferencesContent.getString("content", null);

        if (title != null && content != null) {
            b = true;
            titles = title.split(",");
            contents = content.split(",");
            adapter = new MyListAdapter(this, titles, contents);
            listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notes_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.add_note:
                startActivity(new Intent(this, AddNoteActivity.class));
                return true;
            case R.id.delete_note:
                startActivity(new Intent(this, DeleteNoteActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        sharedpreferencesTitles = getSharedPreferences("noteTitles", Context.MODE_PRIVATE);
        sharedpreferencesContent = getSharedPreferences("noteContents", Context.MODE_PRIVATE);
        title = sharedpreferencesTitles.getString("title", null);
        content = sharedpreferencesContent.getString("content", null);

        if (title != null && content != null) {
            b = true;
            titles = title.split(",");
            contents = content.split(",");
            adapter = new MyListAdapter(this, titles, contents);
            listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);
        }
    }
}