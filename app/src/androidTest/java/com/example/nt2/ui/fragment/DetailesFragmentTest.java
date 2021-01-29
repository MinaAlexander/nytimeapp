package com.example.nt2.ui.fragment;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.example.nt2.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class DetailesFragmentTest {
//    @Rule
//    public FragmentTestRule<DetailesFragment> mFragmentTestRule = new FragmentTestRule<>(DetailesFragment.class);
//
//
//    @Test
//    public void recycleTest(){
//        Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
//    }
@Rule
public FragmentTestRule<?, DetailesFragment> fragmentTestRule =
        FragmentTestRule.create(DetailesFragment.class);

    @Test
    public void clickButton() throws Exception {
                Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));

//        onView(withText(R.string.button)).perform(click());
//
//        onView(withText(R.string.button_clicked)).check(matches(isDisplayed()));
    }
}