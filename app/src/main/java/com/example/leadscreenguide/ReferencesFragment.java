package com.example.leadscreenguide;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;

public class ReferencesFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_references, container, false);
        final TextView textView = root.findViewById(R.id.text_references);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        MainActivity.setFragOn();
        textView.setText("this screen still needs text");
        return root;
    }


}
