package com.example.emquang;

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

    ListView lvdasach;
    EditText tenbh, tencs;
    Button them, sua, xoa;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tenbh = (EditText) findViewById(R.id.edtmusic);
        tencs = (EditText) findViewById(R.id.edtauthor);
        them = (Button) findViewById(R.id.add);
        sua = (Button) findViewById(R.id.edit);
        xoa = (Button) findViewById(R.id.delete);
        lvdasach = (ListView) findViewById(R.id.listmusic);
        List<Sing> data = new ArrayList<>();
        ArrayAdapter<Sing> adapter;

        data.add(new Sing("Mưa mùa xuân","Hà Anh Tuấn"));
        data.add(new Sing("Mưa mùa hè","Hà Anh Tuấn"));
        data.add(new Sing("Mưa mùa thu","Hà Anh Tuấn"));
        data.add(new Sing("Mưa mùa đông","Hà Anh Tuấn"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        lvdasach.setAdapter(adapter);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bh = tenbh.getText().toString();
                String cs = tencs.getText().toString();
                if (!bh.isEmpty() && !cs.isEmpty()) {
                    data.add(new Sing(bh, cs));
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity3.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                    tenbh.setText("");
                    tencs.setText("");
                } else {
                    Toast.makeText(MainActivity3.this, "Nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                }
            }
        });

        lvdasach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Sing s = data.get(i);
                tenbh.setText(s.getTenBH());
                tencs.setText(s.getTenCS());
                vitri = i;
            }
        });


        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri != -1) {
                    String bh = tenbh.getText().toString();
                    String cs = tencs.getText().toString();
                    if (!bh.isEmpty() && !cs.isEmpty()) {
                        Sing s = data.get(vitri);
                        s.setTenBH(bh);
                        s.setTenCS(cs);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity3.this, "Sửa thành công", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity3.this, "Nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity3.this, "Bạn chưa nhấn vào đối tượng cần sửa", Toast.LENGTH_LONG).show();
                }
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri != -1) {
                    data.remove(vitri);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity3.this, "Xóa thành công", Toast.LENGTH_LONG).show();
                    tenbh.setText("");
                    tencs.setText("");
                    vitri = -1;
                } else {
                    Toast.makeText(MainActivity3.this, "Chọn số điện thoại để xóa", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}