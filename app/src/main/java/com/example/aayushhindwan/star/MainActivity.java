package com.example.aayushhindwan.star;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //private static final NumberFormat FirebaseAuth = ;
    private EditText email1;
    private EditText pass1;
    private Button login1;
    private Button register1;
    private Button rate;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email1=(EditText)findViewById(R.id.etEmail);
        pass1=(EditText)findViewById(R.id.etPass);
        register1=(Button)findViewById(R.id.signup);
        login1=(Button)findViewById(R.id.btlogin);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        rate=(Button)findViewById(R.id.btrating);
        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            //adding profile or the second activity
            startActivity(new Intent(getApplicationContext(),homepage.class));
        }
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // registeruser();
               Intent intent =new Intent(MainActivity.this,signupactivity.class);
               startActivity(intent);
            }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  Intent intent=new Intent(MainActivity.this,Loginactivity.class);
            //startActivity(intent);
                // NOW WE NEED TO OPEN THE PROFILE ACTIVITY AS PER ORIGINAL SETUP
                userlogin();
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,rating.class);
                startActivity(intent);
            }
        });
    }
   /* private void registeruser()
    {
        String em=email1.getText().toString();
        String pa=pass1.getText().toString();
        if(TextUtils.isEmpty(em)||TextUtils.isEmpty(pa))
        {
            Toast.makeText(this,"EMAIL OR PASSWORD CANT BE LEFT EMPTY",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("registerating user");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(em,pa).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"REGISTERED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                    finish();
                    //adding profile or the second activity
                  // startActivity(new Intent(getApplicationContext(),PROFILE_ACTIVITY.class));

                }
                else
                {
                    Toast.makeText(MainActivity.this,"REGISTERED not yet try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/
    private void userlogin()
    {
        String email=email1.getText().toString();
        String pass=pass1.getText().toString();
        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass))
        {
            Toast.makeText(this,"EMAIL OR PASSWORD CANT BE LEFT EMPTY",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("logging in");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                    finish();
                    //startActivity(new Intent(getApplicationContext(),homepage.class));
                    Intent intent =new Intent(MainActivity.this,homepage.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"REGISTERED not yet try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
