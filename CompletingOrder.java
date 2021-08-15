package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CompletingOrder extends AppCompatActivity {
    ArrayList<ArrayList<String>> _specials;
    ArrayList<ArrayList<String>> _order;
    ArrayList<ArrayList<String>> _mains;
    ArrayList<ArrayList<String>> _drinks;

    TextView _dishes, _prices;

    ArrayList<String> _finalD;
    ArrayList<String> _finalP;

    ProgressBar _progressBar;
    int i;
    CountDownTimer _countDownTimer;
    Button _cancel;
    Spinner _tableNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completing_order);

        _progressBar = findViewById(R.id.progressBar);
        _cancel = findViewById(R.id.cancelB);
        _tableNum = findViewById(R.id.tableNum);

        _order = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Order");
        _mains = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("Mains");
        _drinks = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("drink");
        _specials = (ArrayList<ArrayList<String>>) getIntent().getSerializableExtra("special");

        if (_order == null){
            _order = new ArrayList<ArrayList<String>>();
        }

        if (_mains != null) {
            _order.addAll(_mains);
        }
        if (_drinks != null) {
            _order.addAll(_drinks);
        }
        if (_specials != null) {
            _order.addAll(_specials);
        }

        _finalD = new ArrayList<String>();
        _finalP = new ArrayList<String>();

        for (int j=0; j <_order.size(); j++) {
            System.out.println("Order "+(j+1)+": ");
            String text = "";
            ArrayList<String> row = _order.get(j);
            for (int i = 0; i < 2; i++) {
                text = text + row.get(i);
                if (i == 0){
                    text = text+ "x   ";
                }

            }
            _finalD.add(text);
            _finalP.add(row.get(2));

            System.out.println(_finalD.get(j));
            System.out.println(_finalP.get(j));
        }

        _dishes = findViewById(R.id.dish1);
        _prices = findViewById(R.id.price);
        String finalOrder = "";

        for (int i = 0; i < _finalD.size(); i++){
            String text = _finalD.get(i);
            finalOrder = finalOrder + text + "\n";
        }
        _dishes.setText(finalOrder);

        finalOrder = "";

        for (int i = 0; i < _finalP.size(); i++){
            String text = _finalP.get(i);
            finalOrder = finalOrder + text + "\n";
        }
        _prices.setText(finalOrder);

    }

    public void onSubmit(View view){
        _progressBar.setVisibility(View.VISIBLE);
        _cancel.setVisibility(View.VISIBLE);
        i = 0;

        _progressBar.setProgress(i);
        _countDownTimer = new CountDownTimer(5000,100) {
            private boolean warned = false;
            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                i++;
                //int milsLeft = (int) millisUntilFinished;
                //int progress = (5000-milsLeft)/5000*100;
                _progressBar.setProgress((int)i*100/(5000/100));
            }

            @Override
            public void onFinish() {
                //get table number to save it to the appropriate table check
                i++;
                _progressBar.setProgress(100);
                int num = Integer.parseInt(_tableNum.getSelectedItem().toString());

                Intent myIntent = new Intent(getBaseContext(), Table1.class);
                myIntent.putExtra("Order", _order);
                myIntent.putExtra("Table Number", num);
                myIntent.putExtra("Class Name", "CompletingOrder");
                startActivity(myIntent);

            }
        };
        _countDownTimer.start();
    }

    public void onCancel(View view){
        _countDownTimer.cancel();
        _progressBar.setVisibility(View.INVISIBLE);
        _cancel.setVisibility(View.INVISIBLE);
    }

    public void onBack(View view) {
        finish();

    }
}
