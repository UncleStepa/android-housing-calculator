package com.example.housing_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void saveTestimony(View view) {
        Intent intent = new Intent(MainActivity.this, SaveTestimony.class);
        startActivity(intent);
    }

}
