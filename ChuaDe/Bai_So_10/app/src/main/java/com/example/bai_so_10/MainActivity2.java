package com.example.bai_so_10;

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
        List<String> list = new ArrayList<>();
        list.add("Bánh mỳ");
        list.add("Trứng");
        list.add("Sữa");
        list.add("Gạo");
        list.add("Mỳ tôm");
        list.add("Thịt bò");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        listView.setAdapter(adapter);
        Button btnAdd = findViewById(R.id.btnAdd);
        EditText txtItem = findViewById(R.id.txtItem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txtItem.getText().toString().trim();
                if (!s.isEmpty()) {
                    list.add(s);
                    adapter.notifyDataSetChanged();
                    listView.setAdapter(adapter);
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }
        });
        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txtItem.getText().toString().trim();
                for (String e : list) {
                    if (e.equals(s)) {
                        Toast.makeText(MainActivity2.this, "Tìm thấy!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(MainActivity2.this, "Không tìm thấy!", Toast.LENGTH_SHORT).show();
            }
        });
        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index != -1) {
                    list.remove(index);
                    adapter.notifyDataSetChanged();
                    listView.setAdapter(adapter);
                    index = -1;
                }
            }
        });
    }
}