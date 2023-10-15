package com.example.mymethodistapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mymethodistapplication.databinding.ActivityLoginBinding;
import com.example.mymethodistapplication.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
private EditText LoginEmailAddress2;
private EditText  LoginPassword;
private ProgressBar progressBar;
private FirebaseAuth authProfile;

    Button CompleteLoginButton;
    Button YouTubeButton;

    Button FaceBookButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // getSupportActionBar().setTitle("Login");
        LoginEmailAddress2 =findViewById(R.id.editTextTextEmailAddress2);
        LoginPassword = findViewById(R.id.editTextTextPassword);
        progressBar = findViewById(R.id.ProgressBar);
        CompleteLoginButton = findViewById(R.id.CompleteLoginButton);
        authProfile = FirebaseAuth.getInstance();

        YouTubeButton =(Button) findViewById(R.id.YouTubeButton);
        YouTubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@gracewellmethodistchurch/videos")));

            }
        });

        FaceBookButton =(Button) findViewById(R.id.FacebookButton);
        FaceBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/GraceWellMC/")));

            }
        });




        CompleteLoginButton.setOnClickListener(new View.OnClickListener() {

            @Override //Activity To A Fragment
            public void onClick(View view) {

                String editTextTextPassword = LoginPassword.getText().toString();
                String editTextEmailAddress2 = LoginEmailAddress2.getText().toString();



                if(TextUtils.isEmpty(editTextEmailAddress2)){
                    Toast.makeText(LoginActivity.this,"Please Enter Your Email Address",Toast.LENGTH_SHORT).show();
                    LoginEmailAddress2.setError("Email Address Is Required");
                    LoginEmailAddress2.requestFocus();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(editTextEmailAddress2).matches()){
                    Toast.makeText(LoginActivity.this,"Please Enter Your Email Address",Toast.LENGTH_SHORT).show();
                    LoginEmailAddress2.setError("Please Enter A Valid Email Address");
                    LoginEmailAddress2.requestFocus();
                }
                else if(TextUtils.isEmpty(editTextTextPassword)){
                    Toast.makeText(LoginActivity.this,"Please Enter Your Password",Toast.LENGTH_SHORT).show();
                    LoginPassword.setError("Password Is Required");
                    LoginPassword.requestFocus();
                }

                else {
                    progressBar.setVisibility(view.VISIBLE);
                    LoginUser(editTextEmailAddress2, editTextTextPassword);
                }
                    if (editTextEmailAddress2.equals("GracewellAdministration@Gracewell.com")&& editTextTextPassword.equals("Admin1234567")) {
                    startActivity(new Intent(getApplicationContext(), AdminLandingPage.class));
                    overridePendingTransition(0, 0);
                }


                /*

                Fragment HomePage = new HomePage();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginActivity, HomePage).commit();

                 */

            }

        });


    }

    private void LoginUser(String email, String password) {

        authProfile.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK|
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    /*
                    Fragment HomePage = new HomePage();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.LoginActivity, HomePage).commit();
                    //Toast.makeText(LoginActivity.this,"You Are Logged in",Toast.LENGTH_SHORT).show();
*/
                }

                else {
                    Toast.makeText(LoginActivity.this,"Something Has Gone Wrong",Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }


}
