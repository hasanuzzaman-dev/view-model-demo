package com.hasan.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView numberTV;
    private Button button;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        numberTV = findViewById(R.id.numberTV);
        button = findViewById(R.id.button);

        /*** Without viewModel ***/
        /*MainActivityDataGenerator myData = new MainActivityDataGenerator();
        
        String myRandomNumber = myData.getNumber();
        numberTV.setText(myRandomNumber);*/

        //deprecated
        //MainActivityViewModel mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
       /*
       //viewModel
       mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        String myRandomNumber = mainActivityViewModel.getNumber();
        numberTV.setText(myRandomNumber);

        */

        /**** viewModel and Live Data***/

        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        LiveData<String> myRandomNumber = mainActivityViewModel.getMyRandomNumber();

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                numberTV.setText(s);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.createNumber();
            }
        });


        Log.d(TAG, "onCreate: Random Number Set");
        
    }
}