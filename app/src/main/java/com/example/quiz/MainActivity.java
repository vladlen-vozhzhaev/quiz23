package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    Button yesBtn;
    Button noBtn;
    Button showAnswer;
    TextView askTextView;
    Question[] questions = {
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true),
    };
    int questionIndex = 0;
    Question[] answers = new Question[5];
    final String TAG = "SYSTEM INFO:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "вызван метод onCreate()");
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
            questionIndex = savedInstanceState.getInt("questionIndex");

        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswer = findViewById(R.id.showAnswer);
        askTextView = findViewById(R.id.askTextView);
        askTextView.setText(questions[questionIndex].getAsk());
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                startActivity(intent);
            }
        });
    }
    public void checkAnswer(boolean btn){
        if((questions[questionIndex].isAnswer() && btn) || (!questions[questionIndex].isAnswer() && !btn)) {
            Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
            questions[questionIndex].setUserAnswer(true);
        }else{
            Toast.makeText(MainActivity.this, "Не правильно!", Toast.LENGTH_SHORT).show();
            questions[questionIndex].setUserAnswer(false);
        }
        answers[questionIndex] = questions[questionIndex];
        questionIndex++;
        if(questionIndex == questions.length){
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("answers", answers);
            startActivity(intent);
        }else askTextView.setText(questions[questionIndex].getAsk());
        //questionIndex = (questionIndex+1)%questions.length;

    }
    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("questionIndex", questionIndex);
        Log.i(TAG, "вызван метод onSaveInstanceState");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG, "вызван метод onStart()");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG, "вызван метод onResume()");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG, "вызван метод onPause()");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG, "вызван метод onStop()");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "вызван метод onDestroy()");
    }
}