//Assignment 03 - CreateUserActivity.java - Brandon Tiseo

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

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nameInput = findViewById(R.id.nameInput);
        EditText emailInput = findViewById(R.id.emailInput);
        RadioGroup roleRadioGroup = findViewById(R.id.roleRadioGroup);
        Button nextButton = findViewById(R.id.submitButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
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
                    Intent intent = new Intent(CreateUserActivity.this, ProfileActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finish();
                } catch (Exception e){
                    Toast.makeText(CreateUserActivity.this, "Invalid input, please make sure all fields are filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}