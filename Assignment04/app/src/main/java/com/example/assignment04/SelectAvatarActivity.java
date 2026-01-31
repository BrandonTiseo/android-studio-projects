package com.example.assignment04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectAvatarActivity extends AppCompatActivity {

    private int selectedImageFile;

    private ImageView profileF1;
    private ImageView profileF2;
    private ImageView profileF3;
    private ImageView profileM1;
    private ImageView profileM2;
    private ImageView profileM3;

    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_avatar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        profileF1 = findViewById(R.id.profileF1);
        profileF2 = findViewById(R.id.profileF2);
        profileF3 = findViewById(R.id.profileF3);
        profileM1 = findViewById(R.id.profileM1);
        profileM2 = findViewById(R.id.profileM2);
        profileM3 = findViewById(R.id.profileM3);

        cancelButton = findViewById(R.id.cancelButton);

        profileF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageFile = R.drawable.avatar_f_1;
                sendProfileSelection();
            }
        });

        profileF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageFile = R.drawable.avatar_f_2;
                sendProfileSelection();
            }
        });

        profileF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageFile = R.drawable.avatar_f_3;
                sendProfileSelection();
            }
        });

        profileM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageFile = R.drawable.avatar_m_1;
                sendProfileSelection();
            }
        });

        profileM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageFile = R.drawable.avatar_m_2;
                sendProfileSelection();
            }
        });

        profileM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageFile = R.drawable.avatar_m_3;
                sendProfileSelection();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void sendProfileSelection() {
        Intent intent = new Intent();
        intent.putExtra("selectedImageFile", selectedImageFile);
        setResult(RESULT_OK, intent);
        finish();
    }
}