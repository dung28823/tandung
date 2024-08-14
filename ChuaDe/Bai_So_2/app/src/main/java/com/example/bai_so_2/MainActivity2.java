package com.example.bai_so_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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
        ListView listView = findViewById(R.id.listView);
        String[] arr = new String[] {"Cộng", "Trừ", "Nhân", "Chia", "JSON"};
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        listView.setAdapter(adapter);
        final int[] index = {-1};
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index[0] = position;
            }
        });
        Button btnThucHien = findViewById(R.id.btnThucHien);
        btnThucHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index[0] == -1) {
                    Toast.makeText(MainActivity2.this, "Bạn chưa chọn lựa chọn bài toán", Toast.LENGTH_SHORT).show();
                } else if (index[0] == 0) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                } else if (index[0] == 4) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                    startActivity(intent);
                }
            }
        });
        Button btnThoat = findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}