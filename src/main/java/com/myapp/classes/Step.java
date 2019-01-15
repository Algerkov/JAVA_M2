package com.myapp.classes;

import com.myapp.entity.Answer;
import com.myapp.entity.Question;
import com.myapp.service.QuestionService;

public class Step {
    private int stepNumber;
    private String stepName;
    private Question question;
    private int nbUsers;


    public Step(int stepNumber, String stepName){
        setStepNumber(stepNumber);
        setStepName(stepName);
    }

    public Step(int stepNumber, String stepName, Question question){
        setStepNumber(stepNumber);
        setStepName(stepName);
        setQuestion(question);
    }

    public void updateStep(QuestionService questionService){
        int i=0;
        if (question != null) {
            this.question = questionService.findById(question.getId()).get();
            for (Answer ans : question.getAnswers()) {
                i += ans.getStat().getNbAnswers();
            }
        }
        nbUsers = i;
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

    public int getNbUsers() {
        return nbUsers;
    }

    public void setNbUsers(int nbUsers) {
        this.nbUsers = nbUsers;
    }
}
