package com.example.eng3k;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupTabFragment extends Fragment implements View.OnClickListener{
    EditText signupEmail, signupPass,userName,signupPasscon;
    Button signupButt;
    float v=0;
    ProgressBar signupProgress;
    private FirebaseAuth sAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);

        sAuth=FirebaseAuth.getInstance();


        signupEmail=root.findViewById(R.id.signupEmail);
        signupPass=root.findViewById(R.id.signupPass);
        userName=root.findViewById(R.id.userName);
        signupPasscon=root.findViewById(R.id.signupPasscon);
        signupButt=root.findViewById(R.id.signupButt);
        signupProgress=root.findViewById(R.id.signupProgress);

        signupButt.setOnClickListener(this);


        signupEmail.setTranslationY(800);
        signupPass.setTranslationY(800);
        userName.setTranslationY(800);
        signupPasscon.setTranslationY(800);
        signupButt.setTranslationY(800);


        signupEmail.setAlpha(v);
        signupPass.setAlpha(v);
        userName.setAlpha(v);
        signupPasscon.setAlpha(v);
        signupButt.setAlpha(v);


        signupEmail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        signupPass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        userName.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signupPasscon.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        signupButt.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();





        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signupButt:
                signupUser();
                break;
        }
    }

    private void signupUser() {
        final String email=signupEmail.getText().toString().trim();
        String password=signupPass.getText().toString().trim();
        final String name=userName.getText().toString().trim();
        String confirmpassword=signupPasscon.getText().toString().trim();

        if (name.isEmpty()){
            userName.setError("Name Required!");
            userName.requestFocus();
            return;
        }

        if (email.isEmpty()){
            signupEmail.setError("Email Required!");
            signupEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            signupPass.setError("Password Required!");
            signupPass.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches() && !email.isEmpty()){
            signupEmail.setError("Please provide valid email!");
            signupEmail.requestFocus();
            return;
        }
        if (password.length()<6 && !password.isEmpty()){
            signupPass.setError("Password must be atleast 6 characters!");
            signupPass.requestFocus();
            return;
        }
        if(!password.equals(confirmpassword)){
            signupPasscon.setError("doesn't match with the previous one!");
            signupPasscon.requestFocus();
            return;
        }

        signupProgress.setVisibility(View.VISIBLE);
        sAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user=new User(name,email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(getActivity(),"User has been registered successfully",Toast.LENGTH_LONG).show();
                                        signupProgress.setVisibility(View.GONE);
                                    }else {
                                        Toast.makeText(getActivity(),"Registration Failed!",Toast.LENGTH_LONG).show();
                                        signupProgress.setVisibility(View.GONE);

                                    }
                                }
                            });
                        }else {
                            Toast.makeText(getActivity(),"Registration Failed!",Toast.LENGTH_LONG).show();
                            signupProgress.setVisibility(View.GONE);
                        }
                    }
                });
    }
}
