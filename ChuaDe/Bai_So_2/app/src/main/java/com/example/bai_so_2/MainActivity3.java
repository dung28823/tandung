package com.example.bai_so_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnCong = findViewById(R.id.btnCong);
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtSoa = findViewById(R.id.txtSoa);
                EditText txtSob = findViewById(R.id.txtSob);
                TextView txtKetQua = findViewById(R.id.txtKetQua);
                try {
                    if (txtSoa.getText().toString().equals("") || txtSob.getText().toString().equals("")) {
                        txtKetQua.setText("Ô nhập không được để trống!");
                    } else {
                        Double sum = Double.parseDouble(txtSoa.getText().toString()) + Double.parseDouble(txtSob.getText().toString());
                        txtKetQua.setText("Kết quả của phép cộng là: " + sum);
                    }
                } catch (Exception e) {
                    txtKetQua.setText(e.getMessage());
                }
            }
        });
    }
}