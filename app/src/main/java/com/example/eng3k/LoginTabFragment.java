package com.example.eng3k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {
    EditText loginEmail, loginPass;
    Button loginButt;
    TextView forgotPass;
    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        loginEmail=root.findViewById(R.id.loginemail);
        loginPass=root.findViewById(R.id.loginPass);
        loginButt=root.findViewById(R.id.loginButt);
        forgotPass=root.findViewById(R.id.forgotPass);

        loginEmail.setTranslationY(800);
        loginPass.setTranslationY(800);
        loginButt.setTranslationY(800);
        forgotPass.setTranslationY(800);


        loginEmail.setAlpha(v);
        loginPass.setAlpha(v);
        loginButt.setAlpha(v);
        forgotPass.setAlpha(v);


        loginEmail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        loginPass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        loginButt.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();






        return root;
    }
}
