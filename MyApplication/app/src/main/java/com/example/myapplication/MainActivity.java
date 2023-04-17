package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insertButton;
    Button updateButton;
    Button deleteButton;
    Button viewButton;
    EditText etName;
    EditText etDOB;
    EditText etContact;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertButton = findViewById(R.id.buttonInsert);
        updateButton = findViewById(R.id.buttonUpdate);
        deleteButton = findViewById(R.id.buttonDelete);
        viewButton = findViewById(R.id.buttonView);

        etName = findViewById(R.id.etName);
        etDOB = findViewById(R.id.etDOB);
        etContact = findViewById(R.id.etContact);

        dbHelper = new DBHelper(MainActivity.this);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String contact = etContact.getText().toString();
                String dob = etDOB.getText().toString();

                if (dbHelper.insertUserData(name, contact, dob)) {
                    Toast.makeText(MainActivity.this, "New Record Inserted Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unable to Insert Data!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String contact = etContact.getText().toString();
                String dob = etDOB.getText().toString();

                if (dbHelper.insertUserData(name, contact, dob)) {
                    Toast.makeText(MainActivity.this, "Record Updated Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unable to Update Data!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();

                if (dbHelper.deleteUserData(name)) {
                    Toast.makeText(MainActivity.this, "Record Deleted Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unable to Delete Data!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor records = dbHelper.viewUserData();
                if (records.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer allRecords = new StringBuffer();
                while (records.moveToNext()) {
                    allRecords.append("SN: " + records.getString(0) + "\n");
                    allRecords.append("Name: " + records.getString(1) + "\n");
                    allRecords.append("Contact: " + records.getString(2) + "\n");
                    allRecords.append("Date Of Birth: " + records.getString(3) + "\n");
                }

                // Alert box showing user records
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("View all Records");
                builder.setMessage(allRecords.toString());
                builder.show();
            }
        });
    }
}