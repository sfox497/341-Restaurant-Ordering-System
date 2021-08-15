package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Table1 extends AppCompatActivity {
    ArrayList<ArrayList<String>> _order;

    TextView _dishes, _prices, _finalBill, _finalBill2;

    ArrayList<String> _finalD;
    ArrayList<String> _finalP;
    Button _submit;

    ArrayList<ArrayList<Integer>> _total = new ArrayList<ArrayList<Integer>>();
    int _tNum;
    String _name;

    TextView _table, _guests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1);

        _order = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Order");
        _tNum = getIntent().getIntExtra("Table Number", 0);
        _name = getIntent().getStringExtra("Class Name");
        System.out.println("Class Name:"+_name);

        _finalD = new ArrayList<String>();
        _finalP = new ArrayList<String>();

        _finalBill = findViewById(R.id.totalBill);
        _finalBill2 = findViewById(R.id.totalBill2);

        _dishes = findViewById(R.id.dish1);
        _prices = findViewById(R.id.price);
        _submit = findViewById(R.id.send);

        _table = findViewById(R.id.tableView);
        _guests = findViewById(R.id.guestView);

        _table.setText("Table "+_tNum);
        switch (_tNum) {
            case 1:
                _guests.setText("guest: 3");
                break;
            case 2:
                _guests.setText("guest: 4");
                break;
            case 3:
                _guests.setText("guest: 5");
                break;
            case 4:
                _guests.setText("guest: 2");
                break;
        }

        if (_order == null){
            _dishes.setText("No orders yet");
            _prices.setText("");
            _submit.setEnabled(false);
        } else {


            for (int j = 0; j < _order.size(); j++) {
                ArrayList<Integer> amount = new ArrayList<Integer>();

                String text = "";

                ArrayList<String> row = _order.get(j);
                for (int i = 0; i < 2; i++) {
                    text = text + row.get(i);
                    if (i == 0) {
                        //adding amount to array list
                        amount.add(Integer.parseInt(text));
                        //displayed
                        text = text + "x   ";
                    }
                }
                _finalD.add(text);
                _finalP.add(row.get(2));
                //adding price to array list, but first taking away $ sign
                String temp = row.get(2).substring(1);
                amount.add(Integer.parseInt(temp));

                //adding amount and prices to one main array list
                _total.add(amount);
            }

            String finalOrder = "";

            for (int i = 0; i < _finalD.size(); i++) {
                String text = _finalD.get(i);
                finalOrder = finalOrder + text + "\n";
            }
            _dishes.setText(finalOrder);

            finalOrder = "";

            for (int i = 0; i < _finalP.size(); i++) {
                String text = _finalP.get(i);
                finalOrder = finalOrder + text + "\n";
            }
            _prices.setText(finalOrder);

            int bill = calculateTotalPrice(_total);
            _finalBill.setText("Total price: $" + bill + ".00");
            //with tax
            double tax = bill * 1.12;
            tax = Math.round(tax * 100.0) / 100.0;
            _finalBill2.setText("Including 12% tax: $" + tax);
        }
    }

    private int calculateTotalPrice(ArrayList<ArrayList<Integer>> total){
        int TOTAL = 0;
        for (int j=0; j < total.size(); j++) {
            ArrayList<Integer> row = total.get(j);

            //getting price and amount value to times by
            int amount = row.get(0);
            int price = row.get(1);

            TOTAL = TOTAL + (amount*price);

        }
        return TOTAL;
    }

    public void onEdit(View view){
        Intent myIntent = new Intent(getBaseContext(), EditOrder.class);
        myIntent.putExtra("Order", _order);
        myIntent.putExtra("Table Number", _tNum);
        startActivity(myIntent);
    }

    public void onBack(View view){
        //seeing which class started this activity
        if (_name == null){
            finish();
        } else {
            //sending info to the Table main screen

            Intent myIntent = new Intent(getBaseContext(), Table.class);
            System.out.println(_tNum);
            switch (_tNum) {
                case 1:
                    myIntent.putExtra("Table1", _order);
                    break;
                case 2:
                    myIntent.putExtra("Table2", _order);
                    break;
                case 3:
                    myIntent.putExtra("Table3", _order);
                    break;
                case 4:
                    myIntent.putExtra("Table4", _order);
                    break;
                case 0:
                    //there is no orders for this table so do not attach any orders

            }
            myIntent.putExtra("Table Number", _tNum);
            startActivity(myIntent);
        }
    }
}
