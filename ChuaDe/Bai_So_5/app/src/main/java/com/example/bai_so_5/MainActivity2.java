package com.example.bai_so_5;

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
        RadioButton rdDecaf = findViewById(R.id.rdDecaf);
        rdDecaf.setChecked(true);
        RadioButton rdExp = findViewById(R.id.rdExp);
        RadioButton rdColom = findViewById(R.id.rdColom);
        CheckBox cbCream = findViewById(R.id.cbCream);
        CheckBox cbSugar = findViewById(R.id.cbSugar);
        Button btnPay = findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                if (rdDecaf.isChecked()) {
                    s += rdDecaf.getText().toString() + " & ";
                } else if (rdExp.isChecked()) {
                    s += rdExp.getText().toString() + " & ";
                } else if (rdColom.isChecked()) {
                    s += rdColom.getText().toString() + " & ";
                }
                if (cbCream.isChecked()) {
                    s += cbCream.getText().toString() + " & ";
                }
                if (cbSugar.isChecked()) {
                    s += cbSugar.getText().toString() + " & ";
                }
                if (!s.isEmpty()) {
                    s = s.substring(0, s.length() - 3);
                    Toast.makeText(MainActivity2.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}