package com.example.lab4;

import static org.junit.Assert.*;

import android.app.Activity;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AddNoteActivityTest {

    @Rule
    public ActivityTestRule<AddNoteActivity> addNoteActivityActivityTestRule = new ActivityTestRule<AddNoteActivity>(AddNoteActivity.class);

    public AddNoteActivity addNoteActivity;

    @Before
    public void setUp() throws Exception {
        addNoteActivity = addNoteActivityActivityTestRule.getActivity();
    }

    @Test
    public void addNote() {
        View addNoteButton = addNoteActivity.findViewById(R.id.add_note_button);
        assertNotNull(addNoteButton);
    }

    @After
    public void tearDown() throws Exception {
        addNoteActivity = null;
    }
}