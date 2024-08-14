package com.example.bai_so_3;

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
        CheckBox cbCafe = findViewById(R.id.cbCafe);
        CheckBox cbSua = findViewById(R.id.cbSua);
        CheckBox cbNuocCam = findViewById(R.id.cbNuocCam);
        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                if (cbCafe.isChecked()) {
                    s += cbCafe.getText().toString() + ", ";
                }
                if (cbSua.isChecked()) {
                    s += cbSua.getText().toString() + ", ";
                }
                if (cbNuocCam.isChecked()) {
                    s += cbNuocCam.getText().toString() + ", ";
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
                if (radioButton3.isChecked()) {
                    s2 = radioButton3.getText().toString();
                }
                Toast.makeText(MainActivity2.this, "Menu: " + s + "\n" + "Giá tiền: " + s2, Toast.LENGTH_SHORT).show();
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