package com.example.topquiz20.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private static final String PREF_KEY_FIRSTNAME = "firstname";
    private static final String PREF_KEY_SCORE = "score";
    private SharedPreferences mPreferences;
    private String mPrefFirstName;
    private int mPrefScore;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && resultCode == RESULT_OK) {
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            mPreferences.edit().putInt(PREF_KEY_SCORE,score).apply();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.topquiz20.R.layout.activity_main);
        mUser = new User();

        mPreferences = getPreferences(MODE_PRIVATE);

        mGreetingText = (TextView)findViewById(com.example.topquiz20.R.id.greeting);
        mNameInput = (EditText)findViewById(com.example.topquiz20.R.id.input);
        mPlay = (Button)findViewById(com.example.topquiz20.R.id.mbutton);

        mPrefFirstName = mPreferences.getString(PREF_KEY_FIRSTNAME, null);
        mPrefScore = mPreferences.getInt(PREF_KEY_SCORE,0);

        if(mPrefFirstName != null){
            mGreetingText.setText("Welcom back, "+mPrefFirstName+"!\nYour last score was "+mPrefScore+", will you do better this time?");
        }

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
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString(PREF_KEY_FIRSTNAME,mUser.getFirstName());
                editor.apply();
                Intent gameActivity = new Intent(MainActivity.this,GameActivity.class);
                startActivityForResult(gameActivity,GAME_ACTIVITY_REQUEST_CODE);
            }
        });
    }
}
