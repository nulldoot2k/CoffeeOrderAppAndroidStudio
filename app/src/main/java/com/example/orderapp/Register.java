package com.example.orderapp;

//import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp.Database.DatabaseHelper;

public class Register  extends AppCompatActivity {
    private EditText email, password, repassword, name, telephonenumber, address;
    private Button register;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        DB = new DatabaseHelper(this);

        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPass);
        repassword = findViewById(R.id.txtRePass);
        name = findViewById(R.id.txtName);
        telephonenumber = findViewById(R.id.txtPhone);
        address = findViewById(R.id.txtAddress);
        register = findViewById(R.id.btnReg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = email.getText().toString();
                String getPassword = password.getText().toString();
                String getRepassword = repassword.getText().toString();
                String getName = name.getText().toString();
                String getTelephoneNumber = telephonenumber.getText().toString();
                String getAddress = address.getText().toString();
                if (getEmail.equals("") || getPassword.equals("") || getRepassword.equals("") || getName.equals("") || getTelephoneNumber.equals("") || getAddress.equals("")) {
                    Toast.makeText(Register.this, "Vui long nhap day du thong tin: DM!", Toast.LENGTH_SHORT).show();
                } else {
                    if (getPassword.equals(getRepassword)) {
                        boolean checkuser = DB.checkUser(getEmail);
                        if (checkuser == false) {
                            boolean insert = DB.ínsertData(getEmail, getPassword, getRepassword, getName, getTelephoneNumber, getAddress);
                            if (insert == true) {
                                Toast.makeText(Register.this, "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "Dang ki that bai", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Register.this, "Email nay da ton tai vui long su dung email khac", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Register.this, "mat khau ban nhap khong khop nhau", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }

}

