package com.example.bai_so_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnHienThi = findViewById(R.id.btnHienThi);
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<SinhVien> sinhViens = new ArrayList<>();
                ListView listView = findViewById(R.id.listView);
                listView.setDivider(null);
                String json = "{\n" +
                        "  \"sinhViens\":[\n" +
                        "    {\n" +
                        "      \"TenSv\":\"Trần Văn An\",\n" +
                        "      \"GioiTinh\":\"Nam\",\n" +
                        "      \"NamSinh\":\"2000\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"TenSv\":\"Trần Thị Hà\",\n" +
                        "      \"GioiTinh\":\"Nữ\",\n" +
                        "      \"NamSinh\":\"2001\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject object = new JSONObject(json);
                    JSONArray array = object.getJSONArray("sinhViens");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        SinhVien sinhVien = new SinhVien(ob.getString("TenSv"), ob.getString("GioiTinh"), ob.getString("NamSinh"));
                        sinhViens.add(sinhVien);
                    }
                    SinhVienAdapter adapter = new SinhVienAdapter(MainActivity4.this, R.layout.activity_item, sinhViens);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}