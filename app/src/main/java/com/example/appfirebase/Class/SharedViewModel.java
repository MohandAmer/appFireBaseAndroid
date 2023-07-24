package com.example.appfirebase.Class;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Float> text =new MutableLiveData<>();
    public void setText(Float input){
        text.setValue(input);
    }
    public LiveData<Float> getText(){
        return  text;
    }
}
