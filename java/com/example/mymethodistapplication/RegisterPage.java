package com.example.mymethodistapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mymethodistapplication.databinding.ActivityMainBinding;
import com.example.mymethodistapplication.databinding.ActivityRegisterPageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {


    ActivityRegisterPageBinding binding;
    EditText editTextEmailAddress2;
    EditText editTextTextPassword;
    EditText editTextName;
    EditText editTextSurname;
    EditText editTextPhone;
    DatabaseReference GracewellDB;
    Button CompleteSignUpButton;
    ProgressBar progressBar;

    Button FaceBookButton;
    Button YouTubeButton;
    public static final String TAG="RegisterPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        binding = ActivityRegisterPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding = ActivityRegisterPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editTextEmailAddress2 = findViewById(R.id.editTextEmailAddress2);
        editTextTextPassword  = findViewById(R.id.editTextTextPassword);
        editTextName  = findViewById(R.id.editTextName);
        editTextSurname  = findViewById(R.id.editTextSurname);
        editTextPhone  = findViewById(R.id.editTextPhone);
        CompleteSignUpButton =findViewById(R.id.CompleteSignUpButton);
        progressBar = findViewById(R.id.ProgressBar);


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


        GracewellDB = FirebaseDatabase.getInstance().getReference().child("Gracewell");

        CompleteSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUserData();
            }

        });

    }
    private void insertUserData(){

        String email = editTextEmailAddress2.getText().toString();
        String password = editTextTextPassword.getText().toString();
        String name =  editTextName.getText().toString();
        String surname = editTextSurname.getText().toString();
        String cellNum = editTextPhone.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(RegisterPage.this,"Please Enter Your Email Address",Toast.LENGTH_SHORT).show();
            editTextEmailAddress2.setError("Email Address");
            editTextEmailAddress2.requestFocus();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(RegisterPage.this,"Please Enter Your Email Address",Toast.LENGTH_SHORT).show();
            editTextEmailAddress2.setError("Email Address");
            editTextEmailAddress2.requestFocus();

        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(RegisterPage.this,"Please Enter The Password You Wish To Use",Toast.LENGTH_SHORT).show();
            editTextTextPassword.setError("Password");
            editTextTextPassword.requestFocus();
        }


        else if (editTextTextPassword.length()<7){
            Toast.makeText(RegisterPage.this,"Password Should Be More Than 5 Characters",Toast.LENGTH_SHORT).show();
            editTextTextPassword.setError("Password Too Weak");
            editTextTextPassword.requestFocus();
            editTextTextPassword.clearComposingText();
            //editTextTextPasswordConfirm.clearComposingText();
        }
        else if(TextUtils.isEmpty(name)){
            Toast.makeText(RegisterPage.this,"Please Enter Your First Name",Toast.LENGTH_SHORT).show();
            editTextName.setError("First Name");
            editTextName.requestFocus();
        }
        else if(TextUtils.isEmpty(surname)){
            Toast.makeText(RegisterPage.this,"Please Enter Your Surname",Toast.LENGTH_SHORT).show();
            editTextSurname.setError("Surname");
            editTextSurname.requestFocus();
        }
        else if(TextUtils.isEmpty(cellNum)){
            Toast.makeText(RegisterPage.this,"Please Enter Your CellPhone Number",Toast.LENGTH_SHORT).show();
            editTextPhone.setError("CellPhone Number");
            editTextPhone.requestFocus();
        }
        else if(cellNum.length()!=10){
            Toast.makeText(RegisterPage.this,"Please Re-Enter Your CellPhone Number",Toast.LENGTH_SHORT).show();
            editTextPhone.setError("10 Digits");
            editTextPhone.requestFocus();


        }
        else{
            progressBar.setVisibility(View.VISIBLE);
            registerUser(email,password,name,surname,cellNum);
        }
        

        GracewellDB Gracewell = new GracewellDB(email,password,name,surname,cellNum);

       GracewellDB.push().setValue(Gracewell);

    }

    private void registerUser(String email, String password, String name, String surname, String cellNum) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterPage.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterPage.this,"Account Created Successfully!",Toast.LENGTH_SHORT).show();
                            FirebaseUser firebaseUser = auth.getCurrentUser();

                            firebaseUser.sendEmailVerification();

                            Intent intent = new Intent(RegisterPage.this,HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK|
                                    Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            try {
                                throw task.getException();
                            }
                            catch (FirebaseAuthWeakPasswordException e)
                            {
                                editTextTextPassword.setError("Your Password Is To Weak Try Using Of Letters And/Or Numbers");
                                editTextTextPassword.requestFocus();
                            }
                            catch (FirebaseAuthInvalidCredentialsException e)
                            {
                                editTextEmailAddress2.setError("This Email Address Is Already In Use. Either Try To Login With This Email Or Sign Up With A Different Email");
                                editTextEmailAddress2.requestFocus();
                            }
                            catch (FirebaseAuthUserCollisionException e)
                            {
                                editTextEmailAddress2.setError("This Email Address Is Already In Use. Either Try To Login With This Email Or Sign Up With A Different Email");
                                editTextEmailAddress2.requestFocus();
                            }

                                catch(Exception e)
                                {
                                    Log.e (TAG, e.getMessage());
                                    Toast.makeText(RegisterPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                        }

                    }
                });
    }
}