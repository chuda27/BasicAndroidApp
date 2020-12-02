package com.choirulhuda.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.choirulhuda.basic.activity.CalculatorActivity;
import com.choirulhuda.basic.activity.ListCountryActivity;
import com.choirulhuda.basic.activity.LoginActivity;
import com.choirulhuda.basic.activity.RegisterActivity;
import com.choirulhuda.basic.activity.ShowNameActivity;
import com.choirulhuda.basic.global.GlobalVariable;
import com.choirulhuda.basic.models.Session;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private ImageView imgShowName, imgListCountry, imgCalculator;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgShowName = findViewById(R.id.img_show_name);
        imgListCountry = findViewById(R.id.img_list_country);
        imgCalculator = findViewById(R.id.img_calculate);

        imgShowName.setOnClickListener(this);
        imgListCountry.setOnClickListener(this);
        //imgCalculator.setOnClickListener(this);

        //check intent parse
       /* Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey(GlobalVariable.FLAG_LOGIN_STATUS)) {
                String flag_login = bundle.getString(GlobalVariable.FLAG_LOGIN_STATUS, null);
                Toast.makeText(getApplicationContext(), flag_login, Toast.LENGTH_SHORT).show();
            }
        }*/

        //session login
        session = MyApplication.getSession();
        if (!session.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_show_name:
                Intent showName = new Intent(this, ShowNameActivity.class);
                startActivity(showName);
                break;

            case R.id.img_list_country:
                Intent listCountry = new Intent(this, ListCountryActivity.class);
                startActivity(listCountry);
                break;
        }
    }


    public void actionCalculator(View view) {
        Intent calculator = new Intent(this, CalculatorActivity.class);
        startActivity(calculator);
    }

    public void actionRegister(View view) {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }

    public void actionLogin(View view) {
        if (session.isLoggedIn()) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setMessage("Sudah melakukan login!")
                    .setIcon(R.drawable.ic_logout)
                    .setCancelable(false)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
        } else {
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }
    }

    public void actionLogout(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Logout");
        dialogBuilder.setMessage("Yakin keluar aplikasi?")
                .setIcon(R.drawable.ic_logout)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        session.logout();
                        dialogInterface.dismiss();
                        finish();
                    }
                });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }
}