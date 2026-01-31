package com.example.assignment03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameResult;
    private TextView emailResult;
    private TextView roleResult;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameResult = findViewById(R.id.nameResult);
        emailResult = findViewById(R.id.emailResult);
        roleResult = findViewById(R.id.roleResult);

        Button updateButton = findViewById(R.id.updateButton);


        user = getIntent().getParcelableExtra("user");
        nameResult.setText(user.getName());
        emailResult.setText(user.getEmail());
        roleResult.setText(user.getRole());

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditUserActivity.class);
                intent.putExtra("user", user);
                editUserLauncher.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> editUserLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                user = (User) result.getData().getParcelableExtra("user");
                nameResult.setText(user.getName());
                emailResult.setText(user.getEmail());
                roleResult.setText(user.getRole());
            } else {
                nameResult.setText(user.getName());
                emailResult.setText(user.getEmail());
                roleResult.setText(user.getRole());
            }
        }
    });
}