package com.choirulhuda.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListCountryActivity extends AppCompatActivity {

    ListView lvCountryName;
    String[] countryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country);
        getSupportActionBar().setTitle("Daftar Negara");

        lvCountryName = findViewById(R.id.lv_country_name);

        countryName = new String[] {
                "Afghanistan", "Argentina", "Armenia", "Australia",
                "Bahrain", "Belgium", "Brazil", "Brunei",
                "Canada", "Chile", "China", "Denmark", "Indonesia"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, countryName);
        lvCountryName.setAdapter(adapter);
        lvCountryName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Nama negara: "+countryName[i], Toast.LENGTH_SHORT).show();
            }
        });

        lvCountryName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Long klik pada item ke-"+i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}