//Assignment 03 - EditUserActivity.java - Brandon Tiseo

package com.example.assignment03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nameInput = findViewById(R.id.nameInput);
        EditText emailInput = findViewById(R.id.emailInput);
        RadioGroup roleRadioGroup = findViewById(R.id.roleRadioGroup);

        Button submitButton = findViewById(R.id.submitButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        User user = getIntent().getParcelableExtra("user");
        nameInput.setText(user.getName());
        emailInput.setText(user.getEmail());
        if (user.getRole().equals("Student")) {
            roleRadioGroup.check(R.id.studentRadio);
        } else if(user.getRole().equals("Employee")){
            roleRadioGroup.check(R.id.employeeRadio);
        } else {
            roleRadioGroup.check(R.id.otherRadio);
        }


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String name = nameInput.getText().toString();
                    String email = emailInput.getText().toString();

                    int selectedRole = roleRadioGroup.getCheckedRadioButtonId();
                    String role;
                    if (selectedRole == R.id.studentRadio) {
                        role = "Student";
                    } else if (selectedRole == R.id.employeeRadio) {
                        role = "Employee";
                    } else {
                        role = "Other";
                    }

                    if(name.isEmpty() || email.isEmpty()){
                        throw new Exception();
                    }

                    User user = new User(name, email, role);
                    Intent intent = new Intent(EditUserActivity.this, ProfileActivity.class);
                    intent.putExtra("user", user);
                    setResult(RESULT_OK, intent);
                    finish();
                } catch (Exception e){
                    Toast.makeText(EditUserActivity.this, "Invalid input, please make sure all fields are filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}