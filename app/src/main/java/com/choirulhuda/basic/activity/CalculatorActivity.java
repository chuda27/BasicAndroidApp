package com.choirulhuda.basic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.choirulhuda.basic.R;

public class CalculatorActivity extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setTitle("Kalkulator");

        btnShow = findViewById(R.id.btn_show);
    }

    public void actionButton2(View view) {
        Toast.makeText(this, "Tombol kedua activity kalkulator", Toast.LENGTH_SHORT).show();;
    }
}