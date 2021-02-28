package com.example.eng3k;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTabFragment extends Fragment implements View.OnClickListener{
    EditText loginEmail, loginPass;
    Button loginButt;
    TextView forgotPass;
    ProgressBar loginProgress;

    private FirebaseAuth lAuth;


    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        lAuth=FirebaseAuth.getInstance();


        loginEmail=root.findViewById(R.id.loginemail);
        loginPass=root.findViewById(R.id.loginPass);
        loginButt=root.findViewById(R.id.loginButt);
        forgotPass=root.findViewById(R.id.forgotPass);
        loginProgress=root.findViewById(R.id.loginProgress);

        loginButt.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButt:
                loginUser();
                break;
        }
    }

    private void loginUser() {
        String email=loginEmail.getText().toString().trim();
        String password=loginPass.getText().toString().trim();

        if (email.isEmpty()){
            loginEmail.setError("Email Required!");
            loginEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            loginPass.setError("Password Required!");
            loginPass.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches() && !email.isEmpty()){
            loginEmail.setError("Please provide valid email!");
            loginEmail.requestFocus();
            return;
        }
        if (password.length()<6 && !password.isEmpty()){
            loginPass.setError("Password must be atleast 6 characters!");
            loginPass.requestFocus();
            return;
        }

        loginProgress.setVisibility(View.VISIBLE);

        lAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //redirect to user profile
                    startActivity(new Intent(getActivity(),MainActivity.class));
                }else {
                    Toast.makeText(getActivity(), "Failed to login, try again", Toast.LENGTH_LONG).show();
                    loginProgress.setVisibility(View.GONE);
                }
            }
        });

    }
}
