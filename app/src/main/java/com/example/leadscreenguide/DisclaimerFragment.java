package com.example.leadscreenguide;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DisclaimerFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_disclaimer, container, false);
        final TextView textView1 = root.findViewById(R.id.text_title);
        final TextView textView2 = root.findViewById(R.id.text_disclaimer);
        MainActivity.setFragOn();
        textView1.setText(MainActivity.toSpan("<center><strong>Disclaimer</strong></center>"));
        textView2.setText(
                "Dear Colleague,\n\n" +
                "\tThis tool suggests how you may approach lead screening in many circumstances, but it may not tell you what to do for the unique child before you now in your unique setting.\n\n" +
                "\tUse this as a starting point and then tailor your care to your patient in your setting in your community with your resources. Lead screening standards of care are often state-specific and even community-specific. Be aware of those state and local standards. And as always, do your own thinking.\n\n" +
                "\tFor more information, please consult the documents in the references tab.\n\n");
        return root;
    }

}
