package com.example.leadscreenguide.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.leadscreenguide.R;
import android.text.Html;
import android.text.Spanned;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                ViewModelProviders.of(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        final TextView textView = root.findViewById(R.id.text_about);

        aboutViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

    return root;
    }

    public Spanned toSpan(String str){
        Spanned retVal;
        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.N){
            retVal = Html.fromHtml(str,Html.FROM_HTML_MODE_LEGACY);
        }
        else{
            retVal = Html.fromHtml(str);
        }
        return retVal;
    }
}