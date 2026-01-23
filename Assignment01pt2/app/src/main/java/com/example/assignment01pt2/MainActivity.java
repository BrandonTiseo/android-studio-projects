//Assignment 01 Part 2 - MainActivity.java - Brandon Tiseo


package com.example.assignment01pt2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.materialswitch.MaterialSwitch;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText temperatureInput = findViewById(R.id.temperature_input);
        TextView resultTextView = findViewById(R.id.result_textView);
        RadioGroup conversionRadioGroup = findViewById(R.id.radioGroup);
        Button calculateButton = findViewById(R.id.calculateButton);
        Button resetButton = findViewById(R.id.resetButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double temperature = Double.parseDouble(temperatureInput.getText().toString());
                    int selectedConversion = conversionRadioGroup.getCheckedRadioButtonId();
                    if (selectedConversion == R.id.cToFRadio) {
                        double result = (temperature * 9 / 5) + 32;
                        resultTextView.setText(String.format("%.2f°F", result));
                    } else if (selectedConversion == R.id.fToCRadio) {
                        double result = (temperature - 32) * 5 / 9;
                        resultTextView.setText(String.format("%.2f°C", result));
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid input, enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureInput.setText("");
                resultTextView.setText("N/A");
            }
        });
    }
}