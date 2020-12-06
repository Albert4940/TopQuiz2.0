package com.example.topquiz20.model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiseList;
    private int mAnswerIndex;

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoiseList() {
        return mChoiseList;
    }

    public void setChoiseList(List<String> choiseList) {
        mChoiseList = choiseList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {

        mAnswerIndex = answerIndex;
    }

    public Question(String question, List<String> choiseList, int answerIndex) {
        mQuestion = question;
        mChoiseList = choiseList;
        mAnswerIndex = answerIndex;
    }
}
