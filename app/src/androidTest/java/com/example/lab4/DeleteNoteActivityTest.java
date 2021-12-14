package com.example.lab4;

import static org.junit.Assert.*;

import android.app.Activity;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class DeleteNoteActivityTest {

    @Rule
    public ActivityTestRule<DeleteNoteActivity> deleteNoteActivityActivityTestRule = new ActivityTestRule<DeleteNoteActivity>(DeleteNoteActivity.class);

    public DeleteNoteActivity deleteNoteActivity;

    @Before
    public void setUp() throws Exception {
        deleteNoteActivity = deleteNoteActivityActivityTestRule.getActivity();
    }

    @Test
    public void listView() {
        View listView = deleteNoteActivity.findViewById(R.id.list_view);
        assertNotNull(listView);
    }

    @After
    public void tearDown() throws Exception {
        deleteNoteActivity = null;
    }
}