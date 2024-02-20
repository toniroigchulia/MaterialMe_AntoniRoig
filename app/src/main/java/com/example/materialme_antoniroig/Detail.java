package com.example.materialme_antoniroig;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView sportsTitle = findViewById(R.id.titleDetail);
        TextView sportsSubTitle = findViewById(R.id.subTitleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            String title = intent.getStringExtra("title");
            String subTitle = intent.getStringExtra("subTitle");
            int imageResource = intent.getIntExtra("image_resource", 0);

            if (title != null && imageResource != 0) {
                sportsTitle.setText(title);
                sportsSubTitle.setText(subTitle);
                Glide.with(this).load(imageResource).into(sportsImage);
            } else {
                Toast.makeText(this, "Datos del deporte no disponibles", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No se recibieron datos del deporte", Toast.LENGTH_SHORT).show();
        }
    }
}