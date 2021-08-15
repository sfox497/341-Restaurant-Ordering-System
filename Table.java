package com.example.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Table extends AppCompatActivity {
    ArrayList<ArrayList<String>> _table1;
    ArrayList<ArrayList<String>> _table2;
    ArrayList<ArrayList<String>> _table3;
    ArrayList<ArrayList<String>> _table4;

    int _tNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        _tNum = getIntent().getIntExtra("Table Number", 0);

        switch (_tNum) {
            case 1:
                _table1 = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Table1");
                break;
            case 2:
                _table2 = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Table2");
                break;
            case 3:
                _table3 = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Table3");
                break;
            case 4:
                _table4 = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Table4");
                break;
        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.table);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.table:
                        return true;
                    case R.id.guest:
                        startActivity(new Intent(getApplicationContext(), guest.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }

    public void onTable1(View view) {
        Intent myIntent = new Intent(getBaseContext(), Table1.class);
        myIntent.putExtra("Order", _table1);
        myIntent.putExtra("Table Number", 1);
        startActivity(myIntent);
    }

    public void onTable2(View view) {
        Intent myIntent = new Intent(getBaseContext(), Table1.class);
        myIntent.putExtra("Order", _table2);
        myIntent.putExtra("Table Number", 2);
        startActivity(myIntent);
    }

    public void onTable3(View view) {
        Intent myIntent = new Intent(getBaseContext(), Table1.class);
        myIntent.putExtra("Order", _table3);
        myIntent.putExtra("Table Number", 3);
        startActivity(myIntent);
    }

    public void onTable4(View view) {
        Intent myIntent = new Intent(getBaseContext(), Table1.class);
        myIntent.putExtra("Order", _table4);
        myIntent.putExtra("Table Number", 4);
        startActivity(myIntent);
    }
}
