package com.tathva17.tathva.tathva17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Husni Mubarack on 09-Oct-17.
 */

public class LoginFragment extends Fragment {
    private static final String TAG ="LoginFrag";
    private EditText EmailField;
    private EditText PasswordField;
    private Button LoginButton;
    private TextView Signup;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EmailField = (EditText) view.findViewById(R.id.field_email);
        PasswordField = (EditText) view.findViewById(R.id.field_password);
        LoginButton = (Button) view.findViewById(R.id.login);
        Signup = (TextView) view.findViewById(R.id.gotathva);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTathva();
            }
        });

        if(Utility.isNetworkAvailable(getContext())) {

            Toast.makeText(getContext(), "Sign in with your tathva account", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getContext(),"Network is not available", Toast.LENGTH_LONG).show();
        }
        mAuth = FirebaseAuth.getInstance();


    }

    public void onLogin() {
        if (!validateForm()) {
            return;
        }

        String email, password;
        email = EmailField.getText().toString().trim();
        password = PasswordField.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Fragment fragment = new ProfileFragment();
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.main_fragment, fragment, "fragment")
                                    .commit();
                            getActivity().findViewById(R.id.btn_right_arrow).setVisibility(View.GONE);
                            getActivity().findViewById(R.id.btn_left_arrow).setVisibility(View.GONE);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = EmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            EmailField.setError("Required.");
            valid = false;
        } else {
            EmailField.setError(null);
        }

        String password = PasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            PasswordField.setError("Required.");
            valid = false;
        } else {
            PasswordField.setError(null);
        }

        return valid;
    }
    public void goTathva() {
        String url = "http://tathva.org/tathva.org/tathva16/Website/Main/signup/index.html";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

}
