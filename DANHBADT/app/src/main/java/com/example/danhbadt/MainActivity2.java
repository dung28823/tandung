package com.example.danhbadt;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textViewTen =  findViewById(R.id.textViewTen);
        TextView textViewSoDienThoai = findViewById(R.id.textViewSoDienThoai);

        // Nhận dữ liệu từ Intent
        String ten = getIntent().getStringExtra("TEN");
        String soDienThoai = getIntent().getStringExtra("SO_DIEN_THOAI");

        // Hiển thị dữ liệu
        textViewTen.setText("Tên: " + ten);
        textViewSoDienThoai.setText("Số điện thoại: " + soDienThoai);
    }
}