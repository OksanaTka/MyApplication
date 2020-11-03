package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView main_LBL_title;
    private Button main_BTN_popUp;
    private TextView main_LBL_counter;
    private Button main_BTN_increaseCounter;
    private Button main_BTN_secondActivity;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("pttt", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_BTN_popUp = findViewById(R.id.main_BTN_popUp);
        main_LBL_counter = findViewById(R.id.main_LBL_counter);
        main_BTN_increaseCounter = findViewById(R.id.main_BTN_increaseCounter);
        main_BTN_secondActivity = findViewById(R.id.main_BTN_secondActivity);

        main_BTN_increaseCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseCounter2();
            }
        });

        try {
            if (savedInstanceState != null) {
                int previousCount = savedInstanceState.getInt("MY_INT");
                count = previousCount;
                main_LBL_counter.setText("" + count);
            }
        } catch (Exception ex) { }





        main_BTN_secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity(MainActivity.this);
            }
        });

        //Toast.makeText(this, "Hiii", Toast.LENGTH_SHORT).show();
    }

    private void openSecondActivity(Activity activity) {
        Intent myIntent = new Intent(activity, Activity_Score.class);
        myIntent.putExtra(Activity_Score.EXTRA_KEY_SCORE, count);
        startActivity(myIntent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("pttt", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("MY_INT", count);
    }

    private void increaseCounter2() {
        count++;
        main_LBL_counter.setText("" + count);
        Log.d("pttt", "" + count);
    }


    private void showPopUp(String message) {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton("Close", null)
                .show();

    }


    @Override
    protected void onStart() {
        Log.d("pttt", "onStart");
        super.onStart();

    }

    @Override
    protected void onResume() {
        Log.d("pttt", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("pttt", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("pttt", "onStop");
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        Log.d("pttt", "onDestroy");
        super.onDestroy();
    }

}