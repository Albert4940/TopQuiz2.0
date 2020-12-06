package com.example.topquiz20.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        Collections.shuffle(questionList);
        mQuestionList = questionList;
        mNextQuestionIndex = 0;
    }

    public Question getQuestion(){
        if (mNextQuestionIndex == mQuestionList.size()){
            mNextQuestionIndex = 0;
        }

        return mQuestionList.get(mNextQuestionIndex ++);
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
    }

    public void setQuestionList(List<Question> questionList) {
        mQuestionList = questionList;
    }

    public int getNextQuestionIndex() {
        return mNextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        mNextQuestionIndex = nextQuestionIndex;
    }
}
