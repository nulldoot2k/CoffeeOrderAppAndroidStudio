package com.example.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    Button btnLog;
    Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        btnLog = (Button) findViewById(R.id.btnLoginWelcom);
        btnReg = (Button) findViewById(R.id.btnRegisterWelcom);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, Login.class));
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, Register.class));
            }
        });
    }
}