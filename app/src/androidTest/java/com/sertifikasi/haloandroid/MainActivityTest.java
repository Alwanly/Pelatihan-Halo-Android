package com.sertifikasi.haloandroid;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {
    private final String dummyLength = "12";
    private final String dummyWidth = "7";
    private final String dummyHeight = "6";
    private final String dummyVolume = "504";
    private final String dummyEmpty = "";
    private final String fieldEmpty ="Masih kosong";

    @Before
    public void setUp(){
        ActivityScenario.launch(MainActivity.class);
    }
    @Test
    public void assertGetCalculate(){
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyVolume)));
    }

    @Test
    public void assertEmptyLength(){
        onView(withId(R.id.edt_length)).perform(typeText(dummyEmpty), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate)).perform(click());
        onView(withId(R.id.edt_length)).check(matches(hasErrorText(fieldEmpty)));
    }
}