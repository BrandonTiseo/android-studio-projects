package com.example.assignment04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    private Student student;
    private ImageView avatar;
    private TextView nameResult;
    private TextView emailResult;
    private TextView IDResult;
    private TextView departmentResult;
    private Button updateButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        student = (Student) getIntent().getSerializableExtra("student");

        avatar = findViewById(R.id.avatar);
        nameResult = findViewById(R.id.nameResult);
        emailResult = findViewById(R.id.emailResult);
        IDResult = findViewById(R.id.IDResult);
        departmentResult = findViewById(R.id.departmentResult);

        avatar.setImageResource(student.getAvatar());
        nameResult.setText(student.getName());
        emailResult.setText(student.getEmail());
        IDResult.setText(student.getStudentID());
        departmentResult.setText(student.getDepartment());

        updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    ActivityResultLauncher<Intent> startUpdateProfileForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>(){
        @Override
        public void onActivityResult(ActivityResult result){


        }
    });
}