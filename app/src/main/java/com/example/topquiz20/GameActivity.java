package com.example.topquiz20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private TextView txQuestion;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        txQuestion = (TextView)findViewById(R.id.activity_question_text);
        btn1 = (Button)findViewById(R.id.activity_answer1_btn);
        btn2 = (Button)findViewById(R.id.activity_answer2_btn);
        btn3 = (Button)findViewById(R.id.activity_answer3_btn);
        btn4 = (Button)findViewById(R.id.activity_answer4_btn);
    }
}
