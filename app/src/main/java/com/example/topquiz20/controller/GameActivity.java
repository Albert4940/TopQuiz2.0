package com.example.topquiz20.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz20.R;
import com.example.topquiz20.model.Question;
import com.example.topquiz20.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txQuestion;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.topquiz20.R.layout.activity_game);

        mQuestionBank = this.generateQuestions();
        txQuestion = (TextView)findViewById(R.id.activity_question_text);
        btn1 = (Button)findViewById(R.id.activity_answer1_btn);
        btn2 = (Button)findViewById(R.id.activity_answer2_btn);
        btn3 = (Button)findViewById(R.id.activity_answer3_btn);
        btn4 = (Button)findViewById(R.id.activity_answer4_btn);

        // Use the tag property to 'name' the buttons
        btn1.setTag(0);
        btn2.setTag(1);
        btn3.setTag(2);
        btn4.setTag(3);

        //
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    private  void displayQuestion(final Question question){
        //
        txQuestion.setText(question.getQuestion());
        btn1.setText(question.getChoiseList().get(0));
        btn2.setText(question.getChoiseList().get(1));
        btn3.setText(question.getChoiseList().get(2));
        btn4.setText(question.getChoiseList().get(3));
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int)v.getTag();

        if(responseIndex == mCurrentQuestion.getAnswerIndex()){
            Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Wrong Answer !", Toast.LENGTH_SHORT).show();
        }
    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }
}
