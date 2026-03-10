package com.example.bmicalculator;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        float bmi = getIntent().getFloatExtra("bmi", 0f);
        int age = getIntent().getIntExtra("age", 25);
        boolean isMale = getIntent().getBooleanExtra("isMale", true);

        String bmiFormatted = String.format("%.1f", bmi);
        binding.tvBmiScore.setText(bmiFormatted);

        String category;
        int color;
        String message;
        String recommendation;
        String diet;
        String exercise;

        if (bmi < 18.5) {
            // Underweight
            category = "Underweight";
            color = Color.parseColor("#FF9800");
            message = "You are below the healthy weight range.\nConsider gaining some weight.";
            recommendation = "Your BMI is " + bmiFormatted + ", which is below normal.\n\n"
                    + "• Aim to gain weight gradually — 0.5 to 1 kg per week\n"
                    + "• Increase your daily calorie intake by 300–500 calories\n"
                    + "• Focus on nutrient-dense foods, not junk food\n"
                    + "• Consult a doctor if you are significantly underweight";
            diet = "BREAKFAST\n"
                    + "• Oats with banana, nuts and honey\n"
                    + "• 2 boiled eggs or paneer\n"
                    + "• Full fat milk or smoothie\n\n"
                    + "MID MORNING\n"
                    + "• Handful of mixed nuts and dried fruits\n"
                    + "• Peanut butter on whole wheat toast\n\n"
                    + "LUNCH\n"
                    + "• 2 cups rice or 3 chapatis\n"
                    + "• Dal or chicken curry\n"
                    + "• Vegetables + salad with olive oil\n\n"
                    + "EVENING SNACK\n"
                    + "• Banana milkshake or protein smoothie\n"
                    + "• Cheese sandwich\n\n"
                    + "DINNER\n"
                    + "• Rice or chapati with protein (chicken, fish, paneer)\n"
                    + "• Cooked vegetables\n"
                    + "• Glass of warm milk before bed";
            exercise = "GOAL: Build muscle and increase body weight\n\n"
                    + "STRENGTH TRAINING (3 days/week)\n"
                    + "• Squats — 3 sets x 10 reps\n"
                    + "• Push-ups — 3 sets x 10 reps\n"
                    + "• Dumbbell curls — 3 sets x 12 reps\n"
                    + "• Deadlifts — 3 sets x 8 reps\n\n"
                    + "LIGHT CARDIO (2 days/week)\n"
                    + "• 20 min brisk walking\n"
                    + "• Cycling at easy pace\n\n"
                    + "AVOID: Long runs or intense cardio as it burns too many calories\n\n"
                    + "REST: At least 2 days per week for muscle recovery";

        } else if (bmi < 25.0) {
            // Normal
            category = "Normal Weight";
            color = Color.parseColor("#4CAF50");
            message = "Great! You are in the healthy weight range.\nKeep maintaining it!";
            recommendation = "Your BMI is " + bmiFormatted + ", which is perfectly healthy!\n\n"
                    + "• Maintain your current lifestyle\n"
                    + "• Keep eating balanced meals\n"
                    + "• Stay active regularly\n"
                    + "• Get 7–8 hours of sleep each night\n"
                    + "• Stay hydrated — drink 2–3 litres of water daily";
            diet = "BREAKFAST\n"
                    + "• Oats or whole grain cereal\n"
                    + "• 1–2 eggs or yoghurt\n"
                    + "• Fresh fruit\n\n"
                    + "MID MORNING\n"
                    + "• A piece of fruit or handful of nuts\n\n"
                    + "LUNCH\n"
                    + "• Balanced plate: rice/chapati + protein + veggies\n"
                    + "• Salad with light dressing\n\n"
                    + "EVENING SNACK\n"
                    + "• Green tea and a light snack\n"
                    + "• Fruit or low-fat yoghurt\n\n"
                    + "DINNER\n"
                    + "• Light meal — soup, salad, grilled protein\n"
                    + "• Avoid heavy carbs at night\n\n"
                    + "HYDRATION: Drink 8+ glasses of water daily";
            exercise = "GOAL: Maintain fitness and overall health\n\n"
                    + "CARDIO (3 days/week)\n"
                    + "• 30 min jogging or brisk walking\n"
                    + "• Cycling or swimming\n\n"
                    + "STRENGTH (2 days/week)\n"
                    + "• Full body workout — squats, push-ups, lunges\n"
                    + "• Light to moderate weights\n\n"
                    + "FLEXIBILITY (daily)\n"
                    + "• 10 min stretching or yoga\n"
                    + "• Morning walk\n\n"
                    + "SPORTS/FUN: Play any sport you enjoy 1–2 times a week";

        } else if (bmi < 30.0) {
            // Overweight
            category = "Overweight";
            color = Color.parseColor("#FF5722");
            message = "You are slightly above the healthy range.\nTime to work on losing some weight!";
            recommendation = "Your BMI is " + bmiFormatted + ", which is overweight.\n\n"
                    + "• Aim to lose 0.5 kg per week gradually\n"
                    + "• Reduce daily calories by 300–500\n"
                    + "• Avoid sugary drinks and junk food\n"
                    + "• Increase physical activity\n"
                    + "• Monitor portion sizes at meals\n"
                    + "• Consider speaking to a nutritionist";
            diet = "BREAKFAST\n"
                    + "• Oats with water or low-fat milk\n"
                    + "• 1–2 boiled eggs\n"
                    + "• Green tea instead of sugary drinks\n\n"
                    + "MID MORNING\n"
                    + "• An apple or a handful of almonds\n\n"
                    + "LUNCH\n"
                    + "• 1 cup brown rice or 2 chapatis\n"
                    + "• Dal, grilled chicken or fish\n"
                    + "• Large portion of vegetables\n"
                    + "• Salad without creamy dressing\n\n"
                    + "EVENING SNACK\n"
                    + "• Cucumber, carrot sticks or sprouts\n"
                    + "• Buttermilk or green tea\n\n"
                    + "DINNER\n"
                    + "• Soup + salad + grilled protein\n"
                    + "• Avoid rice or heavy carbs at night\n\n"
                    + "AVOID: Soda, fried food, sweets, white bread";
            exercise = "GOAL: Burn fat and lose weight\n\n"
                    + "CARDIO (4–5 days/week)\n"
                    + "• 40–45 min brisk walking or jogging\n"
                    + "• Cycling or swimming\n"
                    + "• Zumba or aerobics class\n\n"
                    + "STRENGTH (2–3 days/week)\n"
                    + "• Squats — 3 sets x 15 reps\n"
                    + "• Lunges — 3 sets x 12 reps\n"
                    + "• Push-ups — 3 sets x 12 reps\n"
                    + "• Plank — 3 x 30 seconds\n\n"
                    + "DAILY HABITS\n"
                    + "• Take stairs instead of lift\n"
                    + "• Walk after meals for 15–20 min\n"
                    + "• Stand up every hour if you sit for work";

        } else {
            // Obese
            category = "Obese";
            color = Color.parseColor("#D32F2F");
            message = "Your weight poses health risks.\nImmediate lifestyle changes are recommended.";
            recommendation = "Your BMI is " + bmiFormatted + ", which falls in the obese range.\n\n"
                    + "• Please consult a doctor before starting any diet or exercise program\n"
                    + "• Focus on losing weight gradually — 0.5 to 1 kg per week\n"
                    + "• Reduce calorie intake significantly\n"
                    + "• Start with low-impact exercises\n"
                    + "• Monitor blood pressure, blood sugar regularly\n"
                    + "• Consider professional nutritional guidance";
            diet = "BREAKFAST\n"
                    + "• Vegetable omelette (no oil) or poha\n"
                    + "• Green tea or black coffee, no sugar\n\n"
                    + "MID MORNING\n"
                    + "• 1 small fruit (apple, guava, pear)\n"
                    + "• Avoid banana, mango, grapes\n\n"
                    + "LUNCH\n"
                    + "• 1 cup brown rice or 1–2 chapatis\n"
                    + "• Lots of vegetables\n"
                    + "• Dal or lean protein (no frying)\n"
                    + "• Salad before meals to feel full\n\n"
                    + "EVENING SNACK\n"
                    + "• Cucumber or celery sticks\n"
                    + "• Warm water with lemon\n\n"
                    + "DINNER\n"
                    + "• Only soup or steamed vegetables\n"
                    + "• Small portion of dal or grilled chicken\n\n"
                    + "STRICTLY AVOID: Fried food, sweets, soda, fast food,\n"
                    + "alcohol, white rice in large portions, packaged snacks";
            exercise = "GOAL: Safe, gradual weight loss\n\n"
                    + "START SLOW — LOW IMPACT (daily)\n"
                    + "• 20–30 min walking at comfortable pace\n"
                    + "• Water aerobics or swimming (great for joints)\n"
                    + "• Chair exercises if movement is difficult\n\n"
                    + "BUILD UP AFTER 2 WEEKS\n"
                    + "• 45 min brisk walking\n"
                    + "• Light cycling\n"
                    + "• Yoga or stretching\n\n"
                    + "STRENGTH (2 days/week, light)\n"
                    + "• Wall push-ups — 3 x 10\n"
                    + "• Seated leg raises — 3 x 10\n"
                    + "• Standing marching on spot\n\n"
                    + "IMPORTANT: Do NOT do high-impact exercises\n"
                    + "like running or heavy lifting without doctor approval";
        }

        binding.tvBmiCategory.setText(category);
        binding.tvBmiCategory.setTextColor(color);
        binding.tvBmiScore.setTextColor(color);
        binding.tvBmiMessage.setText(message);
        binding.tvRecommendation.setText(recommendation);
        binding.tvDiet.setText(diet);
        binding.tvExercise.setText(exercise);

        binding.btnRecalculate.setOnClickListener(v -> finish());
    }
}