package com.example.leadscreenguide.ui.disclaimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DisclaimerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DisclaimerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is disclaimer fragment_disclaimer");
    }

    public LiveData<String> getText() {
        return mText;
    }
}