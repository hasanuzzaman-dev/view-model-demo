package com.hasan.viewmodeldemo;

import android.util.Log;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();

/*
    private String myRandomNumber;
    public String getNumber() {
        Log.d(TAG, "getNumber: started");

        if (myRandomNumber == null) {
            createNumber();
        }

        return myRandomNumber;
    }

    private void createNumber() {
        Log.d(TAG, "createNumber: started");
        Random random = new Random();
        myRandomNumber = "Number: " + (random.nextInt(10 - 1) - 1);
    }*/

    //Live Data
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getMyRandomNumber(){
        Log.d(TAG, "getMyRandomNumber: started");
        if (myRandomNumber == null){
            myRandomNumber = new MediatorLiveData<>();
            createNumber();
        }

        return myRandomNumber;
    }

    public void createNumber() {
        Log.d(TAG, "createNumber: started!");
        Random random = new Random();
        myRandomNumber.setValue("Number: "+(random.nextInt(10 - 1) + 1));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: performed");
    }
}
