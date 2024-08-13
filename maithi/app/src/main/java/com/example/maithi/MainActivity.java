package com.example.maithi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_DETAIL = 1;
    private ArrayList<DanhBa> contacts;
    private DanhBa selectedContact;
    private ArrayAdapter<DanhBa> adapter;
    private ListView lvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvContacts = findViewById(R.id.lvContacts);
        Button btnDetails = findViewById(R.id.btnDetails);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnthem = findViewById(R.id.btnthem);
        Button btnsua = findViewById(R.id.btnsua);
        Button btnSearch = findViewById(R.id.btnSearch);

        EditText name = findViewById(R.id.txtname);
        EditText phone = findViewById(R.id.txtphone);
        EditText edtSearch = findViewById(R.id.edtSearch);

        contacts = new ArrayList<>();
        contacts.add(new DanhBa("Minh Công", "0123456789"));
        contacts.add(new DanhBa("Hanh Hoa", "0987654321"));
        contacts.add(new DanhBa("Timmy", "0345678912"));
        contacts.add(new DanhBa("Tuấn Hưng", "0943656435"));
        contacts.add(new DanhBa("Hà Vy", "0765432198"));
        contacts.add(new DanhBa("Quang Minh", "0543219876"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        lvContacts.setAdapter(adapter);

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedContact = contacts.get(position);
                name.setText(selectedContact.getName());
                phone.setText(selectedContact.getPhoneNumber());
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = name.getText().toString();
                String newPhone = phone.getText().toString();
                if (!newName.isEmpty() && !newPhone.isEmpty()) {
                    DanhBa newContact = new DanhBa(newName, newPhone);
                    contacts.add(newContact);
                    adapter.notifyDataSetChanged();
                    name.setText("");
                    phone.setText("");
                }
            }
        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedContact != null) {
                    String updatedName = name.getText().toString();
                    String updatedPhone = phone.getText().toString();
                    if (!updatedName.isEmpty() && !updatedPhone.isEmpty()) {
                        selectedContact.setName(updatedName);
                        selectedContact.setPhoneNumber(updatedPhone);
                        adapter.notifyDataSetChanged();
                        name.setText("");
                        phone.setText("");
                        selectedContact = null;
                    }
                }
            }
        });

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedContact != null) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("contact", selectedContact);
                    startActivityForResult(intent, REQUEST_CODE_DETAIL);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedContact != null) {
                    contacts.remove(selectedContact);
                    adapter.notifyDataSetChanged();
                    name.setText("");
                    phone.setText("");
                    selectedContact = null;
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchKeyword = edtSearch.getText().toString();
                boolean found = false;
                for (DanhBa contact : contacts) {
                    if (contact.getName().contains(searchKeyword) || contact.getPhoneNumber().contains(searchKeyword)) {
                        Toast.makeText(MainActivity.this, "Tìm thấy liên lạc: " + contact.getName(), Toast.LENGTH_SHORT).show();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Toast.makeText(MainActivity.this, "Không tìm thấy liên lạc", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_DETAIL && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("deletedContact")) {
                DanhBa deletedContact = (DanhBa) data.getSerializableExtra("deletedContact");
                contacts.remove(deletedContact);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
