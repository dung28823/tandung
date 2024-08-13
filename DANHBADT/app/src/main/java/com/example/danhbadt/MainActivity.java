package com.example.danhbadt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<danhba> data;  // Chuyển tên List thành data
    ArrayAdapter<danhba> adapter;
    ListView lvdanhsach;
    int viTri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvdanhsach = findViewById(R.id.lvdanhsach);  // Chuyển tên ListView thành lvdanhsach
        Button buttonChiTiet = findViewById(R.id.buttonChiTiet);
        Button buttonXoa = findViewById(R.id.buttonXoa);
        Button btGoi = findViewById(R.id.btGoi);
        Button btNhantin = findViewById(R.id.btNt);

        data = new ArrayList<>();
        data.add(new danhba("Minh Công", "0912345678"));
        data.add(new danhba("Hạnh Hoa", "0923456789"));
        data.add(new danhba("Timmy", "0934567890"));
        data.add(new danhba("Tuấn Hưng", "0943656345"));
        data.add(new danhba("Hà Vy", "0956789012"));
        data.add(new danhba("Quang Minh", "0967890123"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lvdanhsach.setAdapter(adapter);

        lvdanhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                viTri = i;  // Cập nhật vị trí được chọn
                String s = data.get(i).toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        buttonChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viTri != -1) {
                    danhba db = data.get(viTri);
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("TEN", db.getTen());
                    intent.putExtra("SO_DIEN_THOAI", db.getSdt());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một mục.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viTri != -1) {
                    data.remove(viTri);
                    adapter.notifyDataSetChanged();
                    viTri = -1;  // Đặt lại viTri sau khi xóa
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một mục.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viTri != -1) {
                    danhba db = data.get(viTri);
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + db.getSdt()));
                    startActivity(callIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một mục.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btNhantin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viTri != -1) {
                    danhba db = data.get(viTri);
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                    smsIntent.setData(Uri.parse("smsto:" + db.getSdt()));
                    smsIntent.putExtra("sms_body", "");  // Bạn có thể chỉnh sửa nội dung tin nhắn ở đây
                    startActivity(smsIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một mục.", Toast.LENGTH_SHORT).show();
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
