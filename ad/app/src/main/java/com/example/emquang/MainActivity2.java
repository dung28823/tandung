package com.example.emquang;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cn,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnAB) {
            Toast.makeText(this, "Chức năng này chưa được cập nhật", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.mnDS) {
            Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
        }
        if (id == R.id.mnCS) {
            Toast.makeText(this, "Chức năng này chưa được cập nhật", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.mnThoat) {
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }


}