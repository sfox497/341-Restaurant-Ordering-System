package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Kitchen extends AppCompatActivity {
    int _state = 0;
    private TableRow _tRow;
    boolean _selected = false;

    String _colour = "empty";

    TableLayout _progress, _ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        _progress = findViewById(R.id.pTable);
        _ready = findViewById(R.id.rTable);
    }

    public void onSelect(View view) {
        TableRow row = (TableRow) view;

        switch (_state) {
            case 0:
                _tRow = (TableRow) view;
                _tRow.setBackgroundColor(Color.YELLOW);
                _state = 1;
                break;
            case 1:
                if (row == _tRow){
                    _tRow.setBackgroundColor(Color.TRANSPARENT);
                    _state = 0;
                }
                break;
        }


    }

    public void onReady(View view){

        if ((_state == 1) && (_tRow.getParent() == _progress)){
            _progress.removeView(_tRow);
            _ready.addView(_tRow);
            _tRow.setBackgroundColor(Color.TRANSPARENT);
            _state = 0;
            _selected = false;
        }

    }

    public void onServed(View view){

        if ((_state == 1)&& (_tRow.getParent() == _ready)){
            _ready.removeView(_tRow);
            _state = 0;
            _selected = false;
        }

    }
}
