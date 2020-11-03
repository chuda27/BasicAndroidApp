package com.choirulhuda.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgShowName, imgListCountry, imgCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgShowName = findViewById(R.id.img_show_name);
        imgListCountry = findViewById(R.id.img_list_country);
        imgCalculator = findViewById(R.id.img_calculate);

        imgShowName.setOnClickListener(this);
        imgListCountry.setOnClickListener(this);
        imgCalculator.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_show_name:
                Toast.makeText(this, "Aplikasi Tampil Nama", Toast.LENGTH_SHORT).show();
                break;

            case R.id.img_list_country:
                Toast.makeText(this, "Aplikasi Tampil Daftar Negara", Toast.LENGTH_SHORT).show();
                break;

            case R.id.img_calculate:
                Toast.makeText(this, "Aplikasi Calculator", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}