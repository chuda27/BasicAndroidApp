package com.choirulhuda.basic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.choirulhuda.basic.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    EditText edtPersonName, edtEmail, edtBDate, edtPhone;
    Button btnSubmit, btnCancel;
    ConstraintLayout consLayReg;

    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");

        edtBDate = findViewById(R.id.edt_birthdate);
        edtPersonName = findViewById(R.id.edt_person_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone_number);
        btnSubmit = findViewById(R.id.btn_submit);
        btnCancel = findViewById(R.id.btn_cancel);

        consLayReg = findViewById(R.id.cons_lay_reg);

        consLayReg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(getApplicationContext(), "Background disentuh", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                myCalendar.set(Calendar.YEAR, i);
                myCalendar.set(Calendar.MONTH, i1);
                myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                updateLabelDate();
            }
        };

        edtBDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        edtBDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!edtBDate.getText().toString().isEmpty()) {
                    edtBDate.setError(null);
                }
            }
        });

        edtPersonName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b && edtPersonName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    edtPersonName.setError("Tidak boleh kosong!");
                }
            }
        });

        /*edtBDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (!edtBDate.getText().toString().isEmpty())
                        edtBDate.setError(null,null);
                }
            }
        });*/

    }

    private void updateLabelDate(){
        String myFormat = "dd-MMM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edtBDate.setText(sdf.format(myCalendar.getTime()));
    }

    public void actionSubmit(View view) {
        boolean isAllComplete = true;
        StringBuilder sb = new StringBuilder();

        if (edtPersonName.getText().toString().equals("")){
            edtPersonName.requestFocus();
            edtPersonName.setError("Harus diisi!");
            sb.append("a");
        }

        if (edtEmail.getText().toString().equals("")){
            edtEmail.requestFocus();
            edtEmail.setError("Harus diisi!");
            sb.append("b");
        }

        if (edtPhone.getText().toString().equals("")){
            edtPhone.requestFocus();
            edtPhone.setError("Harus diisi!");
            sb.append("c");
        }

        if (edtBDate.getText().toString().equals("")){
            edtBDate.requestFocus();
            sb.append("d");
        } else
            edtBDate.setError(null);

        if (sb.length() == 0) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setTitle("Pesan");
            dialogBuilder.setMessage("Data berhasil disimpan!")
                    .setIcon(R.drawable.ic_reg_user)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            finish();
                        }
                    });

            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
        } else {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setTitle("Warning");
            dialogBuilder.setMessage("Lengkapi data!")
                    .setIcon(R.drawable.ic_reg_user)
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
        }
    }

    public void actionCancel(View view) {
        finish();
    }
}