package com.example.assignment04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateProfileActivity extends AppCompatActivity {

    private Student student;

    private ImageView profileInput;
    private EditText nameInput;
    private EditText emailInput;
    private EditText IDInput;
    private RadioGroup departmentRadioGroup;
    private Button saveButton;
    private Button cancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        student = (Student) getIntent().getSerializableExtra("student");

        profileInput = findViewById(R.id.avatar);
        profileInput.setImageResource(student.getAvatar());
        profileInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateProfileActivity.this, SelectAvatarActivity.class);
                startAvatarSelectForResult.launch(intent);
            }
        });

        nameInput = findViewById(R.id.nameInput);
        nameInput.setText(student.getName());

        emailInput = findViewById(R.id.emailInput);
        emailInput.setText(student.getEmail());

        IDInput = findViewById(R.id.IDInput);
        IDInput.setText(student.getStudentID());

        departmentRadioGroup = findViewById(R.id.departmentRadioGroup);
        if(student.getDepartment().equals("CS")) {
            departmentRadioGroup.check(R.id.CSButton);
        } else if(student.getDepartment().equals("SIS")){
            departmentRadioGroup.check(R.id.SISButton);
        } else if(student.getDepartment().equals("BIO")){
            departmentRadioGroup.check(R.id.BIOButton);
        } else {
            departmentRadioGroup.check(R.id.OtherButton);
        }


        saveButton = findViewById(R.id.updateButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = nameInput.getText().toString();
                    String email = emailInput.getText().toString();
                    String studentID = IDInput.getText().toString();
                    int selectedRadioButtonId = departmentRadioGroup.getCheckedRadioButtonId();

                    if (selectedRadioButtonId == R.id.CSButton) {
                        student.setDepartment("CS");
                    } else if (selectedRadioButtonId == R.id.SISButton) {
                        student.setDepartment("SIS");
                    } else if (selectedRadioButtonId == R.id.BIOButton) {
                        student.setDepartment("BIO");
                    } else {
                        student.setDepartment("Other");
                    }

                    if (name.isEmpty() || email.isEmpty() || studentID.isEmpty() || student.getAvatar() == R.drawable.select_image) {
                        throw new Exception();
                    }

                    student.setName(name);
                    student.setEmail(email);
                    student.setStudentID(studentID);

                    Intent intent = new Intent();
                    intent.putExtra("student", student);
                    setResult(RESULT_OK, intent);
                    finish();

                } catch(Exception e){
                    Toast.makeText(UpdateProfileActivity.this, "Please fill in all fields and select an avatar.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    ActivityResultLauncher<Intent> startAvatarSelectForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
    {
        @Override
        public void onActivityResult(ActivityResult result){
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                int selectedImageFile = result.getData().getIntExtra("selectedImageFile", R.drawable.select_image);
                student.setAvatar(selectedImageFile);
                profileInput.setImageResource(selectedImageFile);
            }
        }

    });
}