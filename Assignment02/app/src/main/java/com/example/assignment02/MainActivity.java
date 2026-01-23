//Assignment02 - MainActivity.java - Brandon Tiseo

package com.example.assignment02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

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

        View displayBox = findViewById(R.id.displayColorView);
        displayBox.setBackgroundColor(Color.rgb(64, 128, 0));

        TextView HexResult = findViewById(R.id.HEXResult);
        TextView RGBResult = findViewById(R.id.RGBResult);

        SeekBar redSeek = findViewById(R.id.redSeek);
        SeekBar greenSeek = findViewById(R.id.greenSeek);
        SeekBar blueSeek = findViewById(R.id.blueSeek);

        TextView redSeekText = findViewById(R.id.redSeekText);
        TextView greenSeekText = findViewById(R.id.greenSeekText);
        TextView blueSeekText = findViewById(R.id.blueSeekText);

        Button whiteButton = findViewById(R.id.whiteButton);
        Button blackButton = findViewById(R.id.blackButton);
        Button blueButton = findViewById(R.id.blueButton);
        Button resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBox.setBackgroundColor(Color.rgb(64, 128, 0));
                HexResult.setText("#408000");
                RGBResult.setText("(64, 128, 0)");

                redSeek.setProgress(64);
                redSeekText.setText("64");

                greenSeek.setProgress(128);
                greenSeekText.setText("128");

                blueSeek.setProgress(0);
                blueSeekText.setText("0");
            }
            });

        redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redSeekText.setText(String.valueOf(progress));
                displayBox.setBackgroundColor(Color.rgb(progress, greenSeek.getProgress(), blueSeek.getProgress()));
                HexResult.setText(String.format("#%02X%02X%02X", progress, greenSeek.getProgress(), blueSeek.getProgress()));
                RGBResult.setText(String.format("(%d, %d, %d)", progress, greenSeek.getProgress(), blueSeek.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenSeekText.setText(String.valueOf(progress));
                displayBox.setBackgroundColor(Color.rgb(redSeek.getProgress(), progress, blueSeek.getProgress()));
                HexResult.setText(String.format("#%02X%02X%02X", redSeek.getProgress(), progress, blueSeek.getProgress()));
                RGBResult.setText(String.format("(%d, %d, %d)", redSeek.getProgress(), progress, blueSeek.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueSeekText.setText(String.valueOf(progress));
                displayBox.setBackgroundColor(Color.rgb(redSeek.getProgress(), greenSeek.getProgress(), progress));
                HexResult.setText(String.format("#%02X%02X%02X", redSeek.getProgress(), greenSeek.getProgress(), progress));
                RGBResult.setText(String.format("(%d, %d, %d)", redSeek.getProgress(), greenSeek.getProgress(), progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        whiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBox.setBackgroundColor(Color.rgb(255, 255, 255));
                HexResult.setText("#FFFFFF");
                RGBResult.setText("(255, 255, 255)");

                redSeek.setProgress(255);
                redSeekText.setText("255");

                greenSeek.setProgress(255);
                greenSeekText.setText("255");

                blueSeek.setProgress(255);
                blueSeekText.setText("255");
            }
        });

        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBox.setBackgroundColor(Color.rgb(0, 0, 0));
                HexResult.setText("#000000");
                RGBResult.setText("(0, 0, 0)");

                redSeek.setProgress(0);
                redSeekText.setText("0");

                greenSeek.setProgress(0);
                greenSeekText.setText("0");

                blueSeek.setProgress(0);
                blueSeekText.setText("0");
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBox.setBackgroundColor(Color.rgb(0, 0, 255));
                HexResult.setText("#0000FF");
                RGBResult.setText("(0, 0, 255)");

                redSeek.setProgress(0);
                redSeekText.setText("0");

                greenSeek.setProgress(0);
                greenSeekText.setText("0");

                blueSeek.setProgress(255);
                blueSeekText.setText("255");
            }
        });
    }
}
