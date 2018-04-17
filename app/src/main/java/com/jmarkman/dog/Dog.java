package com.jmarkman.dog;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

public class Dog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
    }

    public void clickDog(View view)
    {
        new DogTask().execute();
    }

    public class DogTask extends AsyncTask<Void, Void, Uri>
    {
        private DogAPI dogAPI;

        @Override
        protected Uri doInBackground(Void... voids)
        {
            String json = "";
            Uri imageURL = null;
            dogAPI = new DogAPI();

            URL url = dogAPI.getDogURL();

            try
            {
                json = dogAPI.getJSON(url);
                imageURL = dogAPI.getImage(json);
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }

            return imageURL;
        }

        protected void onPostExecute(Uri uri)
        {
            ImageView dogImgView = findViewById(R.id.dog_image);
            Picasso.with(dogImgView.getContext())
                    .load(uri)
                    .into(dogImgView);
        }
    }
}
