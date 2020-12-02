package com.choirulhuda.basic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.choirulhuda.basic.MainActivity;
import com.choirulhuda.basic.MyApplication;
import com.choirulhuda.basic.R;
import com.choirulhuda.basic.global.GlobalVariable;
import com.choirulhuda.basic.models.Session;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        //binding komponen
        session = MyApplication.getSession();

    }

    public void actionLogin(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        boolean isSuccess = session.validate(username, password);
        if (isSuccess) {
            /*Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(GlobalVariable.FLAG_LOGIN_STATUS, "logged_in");
            startActivity(intent);*/
            finish();
        } else {
            Snackbar.make(view, "Authentication Failed", Snackbar.LENGTH_SHORT).show();
        }

    }

    public void actionReset(View view) {
        edtUsername.setText("");
        edtPassword.setText("");
    }
}