package com.example.bai_so_11;

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
                List<String> list = new ArrayList<>();
                ListView listView = findViewById(R.id.listView);
                listView.setDivider(null);
                String json = "{\n" +
                        "  \"sinhViens\": [\n" +
                        "    {\n" +
                        "      \"id\": \"SV001\",\n" +
                        "      \"ten\": \"Vũ Khương Duy\",\n" +
                        "      \"lop\": \"DHTI14A1CL\",\n" +
                        "      \"diem\": 9.0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"SV002\",\n" +
                        "      \"ten\": \"Vũ Khương Duy 2\",\n" +
                        "      \"lop\": \"DHTI14A1CL\",\n" +
                        "      \"diem\": 8.5\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"SV003\",\n" +
                        "      \"ten\": \"Vũ Khương Duy 3\",\n" +
                        "      \"lop\": \"DHTI14A1CL\",\n" +
                        "      \"diem\": 8.0\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                try {
                    JSONObject object = new JSONObject(json);
                    JSONArray array = object.getJSONArray("sinhViens");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        list.add(ob.getString("id") + " - " + ob.getString("ten") + " - " + ob.getString("lop") + " - " + ob.getString("diem"));
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity4.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}