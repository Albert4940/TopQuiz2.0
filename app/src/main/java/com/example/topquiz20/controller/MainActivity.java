package com.example.topquiz20.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.topquiz20.model.User;

public class MainActivity extends AppCompatActivity {
    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlay;
    private User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.topquiz20.R.layout.activity_main);
        mUser = new User();
        mGreetingText = (TextView)findViewById(com.example.topquiz20.R.id.greeting);
        mNameInput = (EditText)findViewById(com.example.topquiz20.R.id.input);
        mPlay = (Button)findViewById(com.example.topquiz20.R.id.mbutton);

        mPlay.setEnabled(false);
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlay.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mfirstname = mNameInput.getText().toString();
                mUser.setFirstName(mfirstname);
                Intent gameActivity = new Intent(MainActivity.this,GameActivity.class);
                startActivity(gameActivity);
            }
        });
    }
}
