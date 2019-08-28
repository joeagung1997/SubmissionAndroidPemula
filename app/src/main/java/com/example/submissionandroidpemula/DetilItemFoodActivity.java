package com.example.submissionandroidpemula;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetilItemFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_item_food);


        getIncomingIntent();
    }

    private void getIncomingIntent() {

        if (getIntent().hasExtra("image") && getIntent().hasExtra("tempat") && getIntent().hasExtra("jarak")&&getIntent().hasExtra("desc")) {
//
//            Intent i = getIntent();
//            // Get Selected Image Id
//            int position = i.getExtras().getInt("id");
//            ImageAdapter imageAdapter = new ImageAdapter(this);
//            ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
//            imageView.setImageResource(imageAdapter.thumbImages[position]);
//
            Intent i = getIntent();
            int postion = i.getExtras().getInt("image");
            String namatempat = getIntent().getStringExtra("tempat");
            String jaraktempuh = getIntent().getStringExtra("jarak");
            String description = getIntent().getStringExtra("desc");

            setImage(postion,namatempat,jaraktempuh,description);
        }
    }

    private void setImage(int imageIntent, String namatempat, String jaraktempuh, String description) {

        TextView tempat = findViewById(R.id.tv_detil_tempat);
        TextView jarak = findViewById(R.id.textview_detil_jarak);
        TextView desc = findViewById(R.id.textview_detil_desc);


        tempat.setText(namatempat);
        jarak.setText(jaraktempuh);
        desc.setText(description);

        ImageView imageView = findViewById(R.id.image_detil_photo);
        Glide.with(this)
                .asBitmap()
                .load(imageIntent)
                .into(imageView);
    }
}
