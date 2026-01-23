//Assignment 01 Part 1 - MainActivity.java - Brandon Tiseo


package com.example.assignment01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

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

        EditText temperatureInput = findViewById(R.id.tempInput);
        TextView resultTextView = findViewById(R.id.result_text_view);
        Button fToCButton = findViewById(R.id.f_to_c_button);
        Button cToFbutton = findViewById(R.id.c_to_f_button);
        Button resetButton = findViewById(R.id.reset_button);

        cToFbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double celsius = Double.parseDouble(temperatureInput.getText().toString());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    resultTextView.setText(String.format("%.2f", fahrenheit) + "°F");
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid input, enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fToCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double fahrenheit = Double.parseDouble(temperatureInput.getText().toString());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    resultTextView.setText(String.format("%.2f", celsius) + "°C");
                } catch(Exception e) {
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
