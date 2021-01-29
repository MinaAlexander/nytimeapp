package com.example.nt2.ui.main;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.nt2.R;
import com.example.nt2.ui.fragment.AllArticalsFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

//    @Test
//    public void maincontinerTest() {
//        onView(withId(R.id.main_container)).check(matches(isDisplayed()));
//
//    }

//     @Test
//    public void testallarticallFragment() {
//        Espresso.onView(withId(R.id.recycler)).check(matches(isDisplayed()));
//    }

    @Test
    public void fragment_can_be_instantiated() {
        mainActivityActivityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AllArticalsFragment allArticalsFragment = startAllArticals();
            }
        });

        onView(withId(R.id.recycler)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.recycler), isDisplayed())).perform(swipeUp());
        onView(allOf(withId(R.id.recycler), isDisplayed())).perform(swipeDown());
        RecyclerView recyclerView = mainActivityActivityTestRule.getActivity().findViewById(R.id.recycler);
        int itemcount = recyclerView.getAdapter().getItemCount();
        Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.scrollToPosition(itemcount - 1));

    }

    private AllArticalsFragment startAllArticals() {
        MainActivity activity = (MainActivity) mainActivityActivityTestRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        AllArticalsFragment lunchFragment = new AllArticalsFragment();
        transaction.add(lunchFragment, "voiceFragment");
        transaction.commit();
        return lunchFragment;
    }

    @Test
    public void testSample() {
        if (getRVcount() > 0) {
            onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        }
    }

    private int getRVcount() {
        RecyclerView recyclerView = (RecyclerView) mainActivityActivityTestRule.getActivity().findViewById(R.id.recycler);
        return recyclerView.getAdapter().getItemCount();
    }
}
