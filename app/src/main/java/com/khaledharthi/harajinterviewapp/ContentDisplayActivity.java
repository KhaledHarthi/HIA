package com.khaledharthi.harajinterviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ContentDisplayActivity extends AppCompatActivity {

    TextView titleTV;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_display);

        titleTV = findViewById(R.id.titleTV);
        imageView = findViewById(R.id.imageView);

        Bundle extras = getIntent().getExtras();
        if (extras!=null) {
            String name = extras.getString("name");
            String url = extras.getString("imgURL");

            titleTV.setText(name);

            // Load image using Picasso
            Picasso.get()
                    .load(url)
                    .fit()
                    .placeholder(R.drawable.placeholder)
                    .into(imageView);
        }

    }
}
