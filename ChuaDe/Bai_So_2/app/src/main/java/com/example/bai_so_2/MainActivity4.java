package com.example.bai_so_2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
import java.util.Arrays;
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
                List<String> sinhViens = new ArrayList<>();
                ListView listViewSinhVien = findViewById(R.id.listViewSinhVien);
                listViewSinhVien.setDivider(null);
                String json = "{\n" +
                        "  \"sinhViens\":[\n" +
                        "    {\n" +
                        "      \"MaSv\":\"SV001\",\n" +
                        "      \"TenSv\":\"Tran Van Hung\",\n" +
                        "      \"Tuoi\":\"20\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"MaSv\":\"SV002\",\n" +
                        "      \"TenSv\":\"Tran Thi Ha\",\n" +
                        "      \"Tuoi\":\"20\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"MaSv\":\"SV003\",\n" +
                        "      \"TenSv\":\"Tran Xuan Ba\",\n" +
                        "      \"Tuoi\":\"20\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject object = new JSONObject(json);
                    JSONArray array = object.getJSONArray("sinhViens");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        String s = ob.getString("MaSv") + " - " + ob.getString("TenSv") + " - " + ob.getString("Tuoi");
                        sinhViens.add(s);
                    }
//                    String[] arr = (String[]) sinhViens.toArray();
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity4.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, sinhViens);
                    listViewSinhVien.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }
}