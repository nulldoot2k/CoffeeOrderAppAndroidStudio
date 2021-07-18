package com.example.orderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp.Database.DatabaseHelper;

public class ForgotPassword extends AppCompatActivity {
    private EditText emailOld;
    private Button login;
    private Button forgotpassword;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailOld = (EditText) findViewById(R.id.EnailOld);
        login = (Button) findViewById(R.id.btnReLogin);
        forgotpassword = (Button) findViewById(R.id.btnForgotPassword);
        DB = new DatabaseHelper(this);
        // goi den username tu forgot password
        Intent intent = getIntent();
        emailOld.setText(intent.getStringExtra("username"));

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = emailOld.getText().toString();

                boolean checkuser = DB.checkUser(user);
                if(checkuser == true) {
                    Intent intent = new Intent(getApplicationContext(), ResetPassword.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(ForgotPassword.this, "Emai nay ko ton tai vui long login", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        chuyen huong sang login voi intent
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}