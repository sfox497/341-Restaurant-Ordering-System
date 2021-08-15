package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class starter extends AppCompatActivity {
    ArrayList<ArrayList<String>> _order = new ArrayList<ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        backButton();

    }

    public void onSave(View view){
        _order = new ArrayList<ArrayList<String>>();

        TableRow row1 = findViewById(R.id.tableRow1);
        findHelper(row1);

        TableRow row2 = findViewById(R.id.tableRow2);
        findHelper(row2);

        TableRow row3 = findViewById(R.id.tableRow3);
        findHelper(row3);

        TableRow row4 = findViewById(R.id.tableRow4);
        findHelper(row4);

        TableRow row5 = findViewById(R.id.tableRow5);
        findHelper(row5);

        TableRow row6 = findViewById(R.id.tableRow6);
        findHelper(row6);

        for (int j=0; j <_order.size(); j++) {
            System.out.println("Order "+(j+1)+": ");
            for (int i = 0; i < 3; i++) {
                ArrayList<String> row = _order.get(j);
                System.out.println(row.get(i));
            }
        }

        //loading mains activity
        Intent myIntent = new Intent(getBaseContext(), mainDishes.class);
        myIntent.putExtra("Order", _order);
        startActivity(myIntent);

    }

    private void findHelper(TableRow tr){
        ArrayList<String> row = new ArrayList<String>();
        String text = "";
        for (int i = 1; i< 4; i++){
            View v = tr.getChildAt(i);
            int id = v.getId();
            TextView tv = findViewById(id);
            text = tv.getText().toString();
            if (text.equals("0")){
                break;
            }
            row.add(text);
        }
        if (!text.equals("0")){
            _order.add(row);
        }

    }

    public void onPlus(View view) {
        switch (view.getId()) {

            case R.id.p1:
                TableRow row1 = findViewById(R.id.tableRow1);
                incrementHelper(row1);
                break;

            case R.id.p2:
                TableRow row2 = findViewById(R.id.tableRow2);
                incrementHelper(row2);
                break;

            case R.id.p3:
                TableRow row3 = findViewById(R.id.tableRow3);
                incrementHelper(row3);
                break;

            case R.id.p4:
                TableRow row4 = findViewById(R.id.tableRow4);
                incrementHelper(row4);
                break;

            case R.id.p5:
                TableRow row5 = findViewById(R.id.tableRow5);
                incrementHelper(row5);
                break;

            case R.id.p6:
                TableRow row6 = findViewById(R.id.tableRow6);
                incrementHelper(row6);
                break;

            default:
                break;
        }

    }

    public void onMinus(View view) {
        switch (view.getId()) {

            case R.id.m1:
                TableRow row1 = findViewById(R.id.tableRow1);
                decrementHelper(row1);
                break;

            case R.id.m2:
                TableRow row2 = findViewById(R.id.tableRow2);
                decrementHelper(row2);
                break;

            case R.id.m3:
                TableRow row3 = findViewById(R.id.tableRow3);
                decrementHelper(row3);
                break;

            case R.id.m4:
                TableRow row4 = findViewById(R.id.tableRow4);
                decrementHelper(row4);
                break;

            case R.id.m5:
                TableRow row5 = findViewById(R.id.tableRow5);
                decrementHelper(row5);
                break;

            case R.id.m6:
                TableRow row6 = findViewById(R.id.tableRow6);
                decrementHelper(row6);
                break;

            default:
                break;
        }

    }

    private void incrementHelper(TableRow tr){
        View v = tr.getChildAt(1);
        int id = v.getId();
        TextView tv = findViewById(id);
        CharSequence num = tv.getText();
        int number = Integer.parseInt(num.toString());
        if (number < 10) {
            number++;
        }
        tv.setText(String.valueOf(number));
    }

    private void decrementHelper(TableRow tr){
        View v = tr.getChildAt(1);
        int id = v.getId();
        TextView tv = findViewById(id);
        CharSequence num = tv.getText();
        int number = Integer.parseInt(num.toString());
        if (number > 0) {
            number--;
        }
        tv.setText(String.valueOf(number));
    }

    public void backButton() {
        Button backButton = (Button) findViewById(R.id.starterBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
