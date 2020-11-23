package com.hasan.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView numberTV;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        numberTV = findViewById(R.id.numberTV);

        /*** Without viewModel ***/
        /*MainActivityDataGenerator myData = new MainActivityDataGenerator();
        
        String myRandomNumber = myData.getNumber();
        numberTV.setText(myRandomNumber);*/

        //MainActivityViewModel mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        String myRandomNumber = mainActivityViewModel.getNumber();
        numberTV.setText(myRandomNumber);

        Log.d(TAG, "onCreate: Random Number Set");
        
    }
}