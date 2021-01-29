package com.example.nt2.ui.main;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.nt2.R;
import com.example.nt2.ui.fragment.DetailesFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class DetailesActivityTest {
    @Rule
    public ActivityTestRule<DetailesActivity> detailesActivityActivityTestRule = new ActivityTestRule<>(DetailesActivity.class);

//    @Test
//    public void DetailesFragTest() {
//        onView(withId(R.id.fragment_detailes)).check(matches(isDisplayed()));
//
//    }
//
//    @Before
//    public void init() {
//        detailesActivityActivityTestRule.getActivity()
//                .getSupportFragmentManager().beginTransaction();
//    }

    @Test
    public void fragment_can_be_instantiated() {
        detailesActivityActivityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DetailesFragment detailesFragment = startDetailes();
            }
        });
        onView(withId(R.id.fragment_detailes)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.source_artical)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.title_artical)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.body_artical)).check(matches(isDisplayed()));


    }

    private DetailesFragment startDetailes() {
        DetailesActivity activity = (DetailesActivity) detailesActivityActivityTestRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        DetailesFragment lunchFragment = new DetailesFragment();
        transaction.add(lunchFragment, "voiceFragment");
        transaction.commit();
        return lunchFragment;
    }

}