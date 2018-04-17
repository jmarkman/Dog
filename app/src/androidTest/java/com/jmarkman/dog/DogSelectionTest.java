package com.jmarkman.dog;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;

@RunWith(AndroidJUnit4.class)
public class DogSelectionTest
{
    @Rule
    public ActivityTestRule<Dog> dogActivityTestRule = new ActivityTestRule<>(Dog.class);

    @Test
    public void clickDogButton() throws InterruptedException {
        onView(withId(R.id.get_dog)).perform(click());
        Thread.sleep(2500);
        onView(withId(R.id.test_edit)).perform(typeText("This is example text"));
    }
}