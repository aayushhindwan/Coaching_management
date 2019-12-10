package com.example.aayushhindwan.star;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupactivity extends AppCompatActivity {
    private EditText name;
    private EditText mobile;
    private EditText pass;
    private EditText email;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Button signup;
    private String n1;
    private String m1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        name=(EditText)findViewById(R.id.etName);
        mobile=(EditText)findViewById(R.id.etmobile);
        pass=(EditText)findViewById(R.id.etPasssign);
        email=(EditText)findViewById(R.id.etEmailsign);
        n1=name.getText().toString();
        m1=mobile.getText().toString();
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        signup=(Button)findViewById(R.id.btsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        });
    }
    private  void registeruser()
    {
        String em=email.getText().toString();
        String pa=pass.getText().toString();
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
                    Toast.makeText(signupactivity.this,"REGISTERED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent =new Intent(signupactivity.this,homepage.class);
                    startActivity(intent);
                    //adding profile or the second activity
                    // startActivity(new Intent(getApplicationContext(),PROFILE_ACTIVITY.class));

                }
                else
                {
                    Toast.makeText(signupactivity.this,"REGISTERED not yet try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
