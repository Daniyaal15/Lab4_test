package com.example.lab4;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private String[] maintitle;
    private String[] subtitle;

    public MyListAdapter(Activity context, String[] maintitle, String[] subtitle) {
        super(context, R.layout.list_item, maintitle);
        // TODO Auto-generated constructor stub  

        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView titleText = (TextView) rowView.findViewById(R.id.note_title_text_view);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.note_content_text_view);

        titleText.setText(maintitle[position]);
        subtitleText.setText(subtitle[position]);

        return rowView;

    }

    ;
}  