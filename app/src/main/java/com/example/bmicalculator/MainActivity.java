package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCalculate.setOnClickListener(v -> {
            String weightStr = binding.etWeight.getText().toString().trim();
            String heightStr = binding.etHeight.getText().toString().trim();
            String ageStr = binding.etAge.getText().toString().trim();

            if (weightStr.isEmpty() || heightStr.isEmpty() || ageStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            float weight = Float.parseFloat(weightStr);
            float heightCm = Float.parseFloat(heightStr);
            int age = Integer.parseInt(ageStr);

            if (weight <= 0 || heightCm <= 0 || age <= 0) {
                Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isMale = binding.rgGender.getCheckedRadioButtonId() == R.id.rb_male;

            float heightM = heightCm / 100f;
            float bmi = weight / (heightM * heightM);

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("bmi", bmi);
            intent.putExtra("age", age);
            intent.putExtra("isMale", isMale);
            startActivity(intent);
        });
    }
}