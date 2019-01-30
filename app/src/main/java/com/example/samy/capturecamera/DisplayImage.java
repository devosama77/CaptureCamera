package com.example.samy.capturecamera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayImage extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        imageView=findViewById(R.id.image_id);
        Bitmap bitmap=BitmapFactory.decodeFile(getIntent().getStringExtra("image_file"));
        imageView.setImageBitmap(bitmap);

    }
}
