package com.example.quizapp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This part is react to button.
     * Showing the toast massage regard to the number of good answers.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitAnswers(View view) {
        EditText editText = findViewById(R.id.washingHands);
        String washingHandsAnswer = editText.getText().toString();
        RadioButton petsYesBox = (RadioButton) findViewById(R.id.petsYes);
        boolean hasPetsYesBox = (petsYesBox.isChecked());
        RadioButton petsNoBox = (RadioButton) findViewById(R.id.petsNo);
        boolean hasPetsNoBox = (petsNoBox.isChecked());
        CheckBox coughBox = (CheckBox) findViewById(R.id.cough);
        boolean hasCoughBox = (coughBox.isChecked());
        CheckBox sneezBox = (CheckBox) findViewById(R.id.sneez);
        boolean hasSneezBox = (sneezBox.isChecked());
        CheckBox feverBox = (CheckBox) findViewById(R.id.highBodyTemperature);
        boolean hasFeverBox = (feverBox.isChecked());
        CheckBox noFeverBox = (CheckBox) findViewById(R.id.lowBodyTemperature);
        boolean hasNoFeverBox = (noFeverBox.isChecked());
        RadioButton oneMeter = (RadioButton) findViewById(R.id.oneMeter);
        boolean hasOneMeter = (oneMeter.isChecked());
        RadioButton twoMeter = (RadioButton) findViewById(R.id.twoMeter);
        boolean hasTwoMeter = (twoMeter.isChecked());
        RadioButton toiletPaperYes = (RadioButton) findViewById(R.id.toiletPaperYes);
        boolean hasToiletPaperYes = (toiletPaperYes.isChecked());
        RadioButton toiletPaperNo = (RadioButton) findViewById(R.id.toiletPaperNo);
        boolean hasToiletPaperNo = (toiletPaperNo.isChecked());

        int endScore = calculateScore(hasPetsNoBox, hasCoughBox, hasFeverBox, hasNoFeverBox, hasSneezBox, hasTwoMeter, hasToiletPaperNo, hasOneMeter, hasToiletPaperYes, hasPetsYesBox);
        if (endScore == 6) {
            makeText(this, "Congratulation! All of your answers are good!!", Toast.LENGTH_LONG).show();
        } else if (endScore == 5) {
            makeText(this, "You have five good answers!", Toast.LENGTH_LONG).show();
        } else if (endScore == 4) {
            makeText(this, "You have four good answers!", Toast.LENGTH_LONG).show();
        } else if (endScore == 3) {
            makeText(this, "You have three good answers!", Toast.LENGTH_LONG).show();
        } else if (endScore == 2) {
            makeText(this, "You have two good answers!", Toast.LENGTH_LONG).show();
        } else if (endScore == 1) {
            makeText(this, "You have one good answers!", Toast.LENGTH_LONG).show();
        } else {
            makeText(this, "Oh no! You don't have good answers!", LENGTH_SHORT).show();
        }
    }


    /**
     * This part calculate the end scores.
     */
    private int calculateScore(boolean hasPetsNoBox, boolean hasCoughBox, boolean hasFeverBox, boolean hasNoFeverBox, boolean hasSneezBox, boolean hasTwoMeter, boolean hasToiletPaperNo, boolean hasOneMeter, boolean hasToiletPaperYes, boolean hasPetsYesBox) {
        score = 0;
        EditText editText = findViewById(R.id.washingHands);

        String washingHandsAnswer = editText.getText().toString();
        if (washingHandsAnswer.equals("20")) {
            score += 1;
        }
        if (hasPetsNoBox) {
            score += 1;
        }
        if (hasPetsYesBox) {
            score += 0;
        }
        if (hasCoughBox) {
            score += 1;
        }
        if (hasFeverBox) {
            score += 1;
        }
        if (hasNoFeverBox) {
            score -= 1;
        }
        if (hasSneezBox) {
            score -= 1;
        }
        if (hasOneMeter) {
            score += 0;
        }
        if (hasTwoMeter) {
            score += 1;
        }
        if (hasToiletPaperNo) {
            score += 1;
        }
        if (hasToiletPaperYes) {
            score += 0;
        }
        return (score);
    }
}


