package com.jmarkman.dog;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(AndroidJUnit4.class)
public class DogSelectionTest
{
    // Make a test rule to run UI tests on a specific view!
    @Rule
    public ActivityTestRule<Dog> dogActivityTestRule = new ActivityTestRule<>(Dog.class);

    @Test
    public void clickDogButton() throws InterruptedException
    {
        // You can use loops with instrumented tests to perform an action a certain number of times!
        for (int i = 0; i < 5; i++)
        {
            // You can click buttons!
            onView(withId(R.id.get_dog)).perform(click());
            Thread.sleep(500);
            // And check that things approximately say what they should say!
            onView(withId(R.id.image_url)).check(matches(withText(containsString("dog.ceo"))));
            Thread.sleep(2500);
        }

        // You can even type things!
        onView(withId(R.id.test_edit)).perform(typeText("This is example text"));
        Thread.sleep(2500);
    }
}