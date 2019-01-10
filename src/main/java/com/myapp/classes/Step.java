package com.myapp.classes;

import com.myapp.entity.Question;

public class Step {
    private int stepNumber;
    private String stepName;
    private Question question;

    public Step(int stepNumber, String stepName){
        setStepNumber(stepNumber);
        setStepName(stepName);
    }

    public Step(int stepNumber, String stepName, Question question){
        setStepNumber(stepNumber);
        setStepName(stepName);
        setQuestion(question);
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
