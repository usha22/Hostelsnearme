package com.rockstar.hostelsnearme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    EditText email,pass;
    SharedPreferences sp;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        email=findViewById(R.id.editTextmail);
        pass=findViewById(R.id.editTextPass);

       /* if (auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            finish();
        }*/
    }
    public void Login(View view) {
        String emaill=email.getText().toString();
        String mypass=pass.getText().toString();
          Intent intent=new Intent(this,gpslocation.class);
          startActivity(intent);

        /*String nn=RegisterPage..getString("Emaill","");
        String pp=RegisterPage..getString("Passwoard","");
        if (nn.equals(emaill) && pp.equals(mypass)){
//            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Login failed ", Toast.LENGTH_SHORT).show();
        }*/


        auth.signInWithEmailAndPassword(emaill, mypass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Login Successsful", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }
    public void signup(View view) {
        Intent intent=new Intent(this,RegisterPage.class);
        startActivity(intent);

    }

}
