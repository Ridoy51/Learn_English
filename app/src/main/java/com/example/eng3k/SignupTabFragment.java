package com.example.eng3k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {
    EditText signupEmail, signupPass,mobileNum,signupPasscon;
    Button signupButt;
    float v=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);


        signupEmail=root.findViewById(R.id.signupEmail);
        signupPass=root.findViewById(R.id.signupPass);
        mobileNum=root.findViewById(R.id.mobileNum);
        signupPasscon=root.findViewById(R.id.signupPasscon);
        signupButt=root.findViewById(R.id.signupButt);

        signupEmail.setTranslationY(800);
        signupPass.setTranslationY(800);
        mobileNum.setTranslationY(800);
        signupPasscon.setTranslationY(800);
        signupButt.setTranslationY(800);


        signupEmail.setAlpha(v);
        signupPass.setAlpha(v);
        mobileNum.setAlpha(v);
        signupPasscon.setAlpha(v);
        signupButt.setAlpha(v);


        signupEmail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        signupPass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        mobileNum.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signupPasscon.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        signupButt.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();





        return root;
    }
}
