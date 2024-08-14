package com.example.bai_so_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
        Button btnThoat = findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnXacNhan = findViewById(R.id.btnXacNhan);
        EditText txtHoTen = findViewById(R.id.txtHoTen);
        RadioButton rdNam = findViewById(R.id.rdNam);
        CheckBox cbBongDa = findViewById(R.id.cbBongDa);
        CheckBox cbCauLong = findViewById(R.id.cbCauLong);
        CheckBox cbBongChuyen = findViewById(R.id.cbBongChuyen);
        CheckBox cbBongBan = findViewById(R.id.cbBongBan);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                if (cbBongDa.isChecked()) {
                    s += cbBongDa.getText().toString() + ", ";
                }
                if (cbCauLong.isChecked()) {
                    s += cbCauLong.getText().toString() + ", ";
                }
                if (cbBongChuyen.isChecked()) {
                    s += cbBongChuyen.getText().toString() + ", ";
                }
                if (cbBongBan.isChecked()) {
                    s += cbBongBan.getText().toString() + ", ";
                }
                if (!s.equals("")) {
                    s = s.substring(0, s.length() - 2);
                }
                Toast.makeText(MainActivity2.this, "Họ tên: " + txtHoTen.getText().toString()
                        + ", Giới tính: " + (rdNam.isChecked()? "Nam, " : "Nữ, ") + "Sở thích: " + s, Toast.LENGTH_LONG).show();
            }
        });
        Button btnTiep = findViewById(R.id.btnTiep);
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}