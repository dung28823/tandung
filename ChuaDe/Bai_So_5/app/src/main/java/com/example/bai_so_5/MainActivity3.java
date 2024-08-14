package com.example.bai_so_5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<String> tenList = new ArrayList<>();
        Button btnNhap = findViewById(R.id.btnNhap);
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity3.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, tenList);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtTen = findViewById(R.id.txtTen);
                if (txtTen.getText().toString().equals("")) {
                    Toast.makeText(MainActivity3.this, "Tên không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    tenList.add(txtTen.getText().toString());
                    adapter.notifyDataSetChanged();
                    listView.setAdapter(adapter);
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tenList.remove(position);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
            }
        });
    }
}