package com.example.nt2.ui.main;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.nt2.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class DetailesActivityTest {
@Rule
    public ActivityTestRule<DetailesActivity>detailesActivityActivityTestRule=new ActivityTestRule<>(DetailesActivity.class);

//@Test
//    public void recycleTest(){
//    Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
//}

    @Test
    public void DetailesFragTest(){
        onView(withId(R.id.fragment_detailes)).check(matches(isDisplayed()));

//        Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
    }
    @Before
    public void init(){
        detailesActivityActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }
    @Test
    public void testdetailesFragment() {
//        .perform(click());
        Espresso.onView(withId(R.id.source_artical)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.title_artical)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.body_artical)).check(matches(isDisplayed()));
//        onView(allOf(withId(R.id.fragment_textview_two),withEffectiveVisibility(VISIBLE))).
//                check(matches(isDisplayed()));
    }

}