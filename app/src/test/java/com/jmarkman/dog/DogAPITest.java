package com.jmarkman.dog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.net.URL;

import static org.junit.Assert.*;

// Robolectric allows for testing methods that blend both android and pure java utilities together
// Mockito is another such library
@RunWith(RobolectricTestRunner.class)
public class DogAPITest {

    // This test passes, since it's just building a URL
    @Test
    public void getDogURL() throws Exception
    {
        // You can use standard Java in tests without issue
        System.out.println("Running first test");
        DogAPI dog = new DogAPI();
        String expectedURL = "https://dog.ceo/api/breeds/image/random";
        String actualURL = dog.getDogURL().toString();

        // We make an assertion that the following statement is true
        assertEquals(expectedURL, actualURL);
        // We can also make assertions that we know aren't true
        assertFalse(expectedURL.contains("cat"));

        // We can't use assertions to make decisions! Assertions return void.
        // For example, the following is invalid:
        /*
        if (assertEquals(expectedURL, actualURL))
        {
            // do something
        }
         */
    }

    // So does this one, for the same reason
    @Test
    public void getDogURLWithBreed() throws Exception
    {
        System.out.println("Running second test");
        DogAPI dog = new DogAPI();
        String url = dog.getDogURL("corgi", true).toString();

        assertEquals("https://dog.ceo/api/breed/corgi/images/random", url);

        System.out.println("The resulting url for test two is: " + url);

    }

    // Uh oh! This test failed. There should be an associated reason and a stack trace to look at!
    @Test
    public void getJSON() throws Exception
    {
        // If a test fails or runs into an exception, its results will be pushed to the top of
        // the "run" terminal. Notice that this test didn't even fail at its assertion, but failed
        // for an outside reason
        System.out.println("Running third test");
        DogAPI dog = new DogAPI();
        URL url = dog.getDogURL();
        String returnJSON = dog.getJSON(url);
        // While the test may function, some websites don't like when unauthorized bits of code
        // make API GET requests

        assertNotNull(returnJSON);
    }
}