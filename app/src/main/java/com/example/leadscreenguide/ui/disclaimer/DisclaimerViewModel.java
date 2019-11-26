package com.example.leadscreenguide.ui.disclaimer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DisclaimerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DisclaimerViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }



}