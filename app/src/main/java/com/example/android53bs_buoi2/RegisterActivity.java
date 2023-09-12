package com.example.android53bs_buoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister, btnCancel;
    EditText edtPhoneNumber,edtPassword,edtComfirmPassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumer);
        edtPassword = findViewById(R.id.edtPassword);
        edtComfirmPassword = findViewById(R.id.edtComfirmPassword);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhoneNumber.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmPassword = edtComfirmPassword.getText().toString();
                if(phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_LONG).show();
                }else if(phone.length()>11){
                    Toast.makeText(RegisterActivity.this, "Số điện thoại không đúng", Toast.LENGTH_LONG).show();
                }else if(!password.equals(confirmPassword)){
                    Toast.makeText(RegisterActivity.this, "Mật Khẩu không khớp", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("Phone", phone);
                    setResult(RESULT_OK, intent);
                    startActivity(intent);
                    finish();

                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


    }


}