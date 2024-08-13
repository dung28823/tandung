package com.example.emquang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.editTextUsername);
        EditText password = findViewById(R.id.editTextPassword);
        Button loginButton = findViewById(R.id.buttonLogin);
        Button exitButton = findViewById(R.id.buttonCancel);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("") && pass.equals("")) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}