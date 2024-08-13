package com.example.de4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name, sdt;
    Button them, sua, xoa;
    ListView lvdanhsach;
    List<danhba> data = new ArrayList<>();
    ArrayAdapter<danhba> adapter;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvdanhsach = findViewById(R.id.lvdanhsach);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        lvdanhsach.setAdapter(adapter);

        name = findViewById(R.id.ten);
        sdt = findViewById(R.id.sdt);

        them = findViewById(R.id.add);
        sua = findViewById(R.id.update);
        xoa = findViewById(R.id.del);

        // Add initial data
        data.add(new danhba("Bùi Thanh Mai", "0987654321"));
        data.add(new danhba("Phạm Văn Hùng", "0912345678"));
        data.add(new danhba("Nguyễn Văn An", "0934654734"));
        data.add(new danhba("Phạm Văn Hải", "0247373754"));

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = name.getText().toString();
                String dt = sdt.getText().toString();
                if (!ten.isEmpty() && !dt.isEmpty()) {
                    data.add(new danhba(ten, dt));
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                    name.setText("");
                    sdt.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                }
            }
        });

        lvdanhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                danhba selectedDanhBa = data.get(i);
                name.setText(selectedDanhBa.getTen());
                sdt.setText(selectedDanhBa.getSdt());
                vitri = i;
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri != -1) {
                    String ten = name.getText().toString();
                    String dt = sdt.getText().toString();
                    if (ten.isEmpty() || dt.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                    } else {
                        danhba db = data.get(vitri);
                        db.setTen(ten);
                        db.setSdt(dt);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Sửa thành công", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Chọn số điện thoại để sửa", Toast.LENGTH_LONG).show();
                }
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri != -1) {
                    data.remove(vitri);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_LONG).show();
                    name.setText("");
                    sdt.setText("");
                    vitri = -1;
                } else {
                    Toast.makeText(MainActivity.this, "Chọn số điện thoại để xóa", Toast.LENGTH_LONG).show();
                }
            }
        });

        lvdanhsach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                danhba db = data.get(i);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + db.getSdt()));
                startActivity(intent);
                return true;
            }
        });

    }
}
