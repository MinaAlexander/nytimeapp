package com.example.nt2.ui.main;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.nt2.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void maincontinerTest(){
        Espresso.onView(withId(R.id.main_container)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.fragment_detailes_large)).check(matches(isDisplayed()));

//        Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
    }
    @Before
    public void init(){
        mainActivityActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }
    @Test
    public void testallarticallFragment() {
//        .perform(click());
        Espresso.onView(withId(R.id.recycler)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.title_artical)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.body_artical)).check(matches(isDisplayed()));
//        onView(allOf(withId(R.id.fragment_textview_two),withEffectiveVisibility(VISIBLE))).
//                check(matches(isDisplayed()));
    }
    @Test
    public void clickButton() throws Exception {
        Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));

//        onView(withText(R.string.button)).perform(click());
//
//        onView(withText(R.string.button_clicked)).check(matches(isDisplayed()));
    }

}