package com.example.leadscreenguide.ui.references;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReferencesViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public ReferencesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is references fragment_references");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
