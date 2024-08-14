package com.example.bai_so_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CheckBox cbJava = findViewById(R.id.cbJava);
        CheckBox cbCS = findViewById(R.id.cbCS);
        CheckBox cbAndroid = findViewById(R.id.cbAndroid);
        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                if (cbJava.isChecked()) {
                    s += cbJava.getText().toString() + ", ";
                }
                if (cbCS.isChecked()) {
                    s += cbCS.getText().toString() + ", ";
                }
                if (cbAndroid.isChecked()) {
                    s += cbAndroid.getText().toString() + ", ";
                }
                if (!s.equals("")) {
                    s = s.substring(0, s.length() - 2);
                }
                String s2 = "";
                if (radioButton1.isChecked()) {
                    s2 = radioButton1.getText().toString();
                }
                if (radioButton2.isChecked()) {
                    s2 = radioButton2.getText().toString();
                }
                Toast.makeText(MainActivity2.this, "Môn học: " + s + "\n" + "Giới tính: " + s2, Toast.LENGTH_SHORT).show();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}