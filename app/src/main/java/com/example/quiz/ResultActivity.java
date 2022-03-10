package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);
        Question[] answers = (Question[]) getIntent().getSerializableExtra("answers");
        resultTextview = findViewById(R.id.resultTextView);
        for (int i = 0; i < answers.length; i++) {
            Question answer = answers[i];
            if(answer.isUserAnswer())
                resultTextview.append(answer.getAsk()+" - Правильно\n");
            else
                resultTextview.append(answer.getAsk()+" - Не правильно");
        }
    }
}