package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EditOrder extends AppCompatActivity {
    int table_id;
    int guest_id;
    int order_id;
    int item_id;
    int mod_id;

    ArrayList<ArrayList<String>> _order;
    int _tNum;
    TextView _table;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);

        backButton();

        _order = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Order");
        _tNum = getIntent().getIntExtra("Table Number", 0);
        System.out.println(_tNum);
        _table = findViewById(R.id.table_id);
        _table.setText(Integer.toString(_tNum));

    }

    public void backButton() {
        Button backButton = (Button) findViewById(R.id.confirm);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
