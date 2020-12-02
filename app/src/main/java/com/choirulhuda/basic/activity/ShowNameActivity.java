package com.choirulhuda.basic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.choirulhuda.basic.R;

public class ShowNameActivity extends AppCompatActivity {

    EditText edtInputName;
    Button btnShowName;
    TextView tvResultName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        getSupportActionBar().setTitle("Tampil Nama");

        edtInputName = findViewById(R.id.edt_input_name);
        btnShowName = findViewById(R.id.btn_show_name);
        tvResultName = findViewById(R.id.tv_result_name);
    }

    public void actionShowName(View view) {
        String name = edtInputName.getText().toString();
        if (!name.equals("")){
            tvResultName.setText("Nama saya "+name);
        } else {
            Toast.makeText(this, R.string.kolom_tidak_boleh_kosong, Toast.LENGTH_SHORT).show();
        }
    }
}