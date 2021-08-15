 package com.example.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startersButton();
        mainDishesButton();
        drinksButton();
        specialsButton();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.guest:
                        startActivity(new Intent(getApplicationContext(), guest.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.table:
                        startActivity(new Intent(getApplicationContext(), Table.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });



    }
     public void startersButton() {
        Button starterButton = (Button) findViewById(R.id.starters);
        starterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, starter.class));
            }
        });

    }
     public void mainDishesButton() {
         Button mainDishesButton = (Button) findViewById(R.id.mainDishes);
         mainDishesButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, mainDishes.class));
             }
         });
     }
     public void drinksButton() {
         Button drinksButton = (Button) findViewById(R.id.drinks);
         drinksButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, drink.class));
             }
         });
    }
     public void specialsButton() {
         Button specialsButton = (Button) findViewById(R.id.specials);
         specialsButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, special.class));
             }
         });
     }
 }

