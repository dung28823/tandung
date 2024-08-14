package com.example.bai_so_11;

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
    private int index = -1;
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
        String[] arr = new String[] {"Tổng hai số", "Thương hai số", "Nghe nhạc", "Tạo hoạt hình", "Edit contact", "Insert contact", "Phân tích JSON"};
        ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }
        });
        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == -1) {
                    Toast.makeText(MainActivity2.this, "Bạn chưa chọn lựa chọn nào!", Toast.LENGTH_SHORT).show();
                } else if (index == 1) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                } else if (index == 6) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                    startActivity(intent);
                }
            }
        });
        Button btnExit2 = findViewById(R.id.btnExit2);
        btnExit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}