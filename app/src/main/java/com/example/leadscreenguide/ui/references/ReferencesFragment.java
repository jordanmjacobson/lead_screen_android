package com.example.leadscreenguide.ui.references;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.text.method.LinkMovementMethod;
import android.text.Html;
import android.text.Spanned;

import com.example.leadscreenguide.R;

public class ReferencesFragment extends Fragment {

    private ReferencesViewModel referencesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        referencesViewModel =
                ViewModelProviders.of(this).get(ReferencesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_references, container, false);
        final TextView textView = root.findViewById(R.id.text_references);

        referencesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        textView.setMovementMethod(LinkMovementMethod.getInstance());
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
