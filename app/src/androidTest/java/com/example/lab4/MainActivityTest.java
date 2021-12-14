package com.example.lab4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

import android.app.Activity;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    public MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityTestActivityTestRule.getActivity();
    }

    @Test
    public void listView() {
        View listView = mainActivity.findViewById(R.id.list_view);
        assertNotNull(listView);
    }

    @Test
    public void menuItems() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Add Note")).perform(click());
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}