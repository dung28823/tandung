package com.example.bai_so_7;

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
                List<String> nhanViens = new ArrayList<>();
                ListView listView = findViewById(R.id.listView);
                listView.setDivider(null);
                String json = "{\n" +
                        "  \"congNhans\": [\n" +
                        "    {\n" +
                        "      \"id\": \"CN001\",\n" +
                        "      \"ten\": \"Duy\",\n" +
                        "      \"luong\": 5000,\n" +
                        "      \"gioiTinh\": \"Nam\",\n" +
                        "      \"chucVu\": \"Bảo vệ\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"CN002\",\n" +
                        "      \"ten\": \"Duy 2\",\n" +
                        "      \"luong\": 7000,\n" +
                        "      \"gioiTinh\": \"Nam\",\n" +
                        "      \"chucVu\": \"Sale\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"CN003\",\n" +
                        "      \"ten\": \"Duy 3\",\n" +
                        "      \"luong\": 6000,\n" +
                        "      \"gioiTinh\": \"Nam\",\n" +
                        "      \"chucVu\": \"HR\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject object = new JSONObject(json);
                    JSONArray array = object.getJSONArray("congNhans");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        String s = ob.getString("id") + " - " + ob.getString("ten") + " - " + ob.getString("luong")
                                + " - " + ob.getString("gioiTinh") + " - " + ob.getString("chucVu");
                        nhanViens.add(s);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity4.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, nhanViens);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }
}