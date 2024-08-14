package com.example.bai_so_6;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        String json = "{\n" +
                "  \"listUser\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"Duy\",\n" +
                "      \"email\": \"duy@gmail.com\",\n" +
                "      \"gender\": \"Nam\",\n" +
                "      \"mobile\": \"0987654321\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"Duy 2\",\n" +
                "      \"email\": \"duy2@gmail.com\",\n" +
                "      \"gender\": \"Nam\",\n" +
                "      \"mobile\": \"0123456789\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"name\": \"Duy 3\",\n" +
                "      \"email\": \"duy3@gmail.com\",\n" +
                "      \"gender\": \"Nữ\",\n" +
                "      \"mobile\": \"01148239412\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        try {
            List<String> list = new ArrayList<>();
            JSONObject object = new JSONObject(json);
            JSONArray array = object.getJSONArray("listUser");
            for (int i = 0; i < array.length(); i++) {
                JSONObject ob = array.getJSONObject(i);
                list.add(ob.getString("id") + " - " + ob.getString("name") + " - " + ob.getString("email") + " - " + ob.getString("gender") + " - " + ob.getString("mobile"));
            }
            ListView listUser = findViewById(R.id.listUser);
            ArrayAdapter adapter = new ArrayAdapter(MainActivity4.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
            listUser.setAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}