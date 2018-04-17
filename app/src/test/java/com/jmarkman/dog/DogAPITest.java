package com.jmarkman.dog;

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by jon on 4/16/2018.
 */
public class DogAPITest {
    @Test
    public void getDogURL() throws Exception
    {
        DogAPI dog = new DogAPI();
        String expectedURL = "https://dog.ceo/api/breeds/image/random";
        String actualURL = dog.getDogURL().toString();

        assertEquals(expectedURL, actualURL);
    }

    @Test
    public void getDogURL1() throws Exception
    {
        DogAPI dog = new DogAPI();
        String url = dog.getDogURL("corgi", true).toString();

        assertEquals("https://dog.ceo/api/breed/corgi/images/random", url);

    }

    @Test
    public void getJSON() throws Exception
    {
        DogAPI dog = new DogAPI();
        URL url = dog.getDogURL();
        String returnJSON = dog.getJSON(url);

        assertNotNull(returnJSON);
    }

    @Test
    public void getImage() throws Exception
    {
        DogAPI dog = new DogAPI();
        assertNotNull(dog);
    }

}