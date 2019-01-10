package com.myapp.classes;

import com.myapp.entity.Question;
import com.myapp.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

public class Quizz {
    private List<Step> steps;
    private int j=0;

    public Quizz(QuestionService questionService){
        int i=0;
        steps = new ArrayList<Step>();
        steps.add(new Step(i, "Init"));

        for(Question question : questionService.getAllById()) {
            steps.add(new Step(++i, "Question", question));
        }

        steps.add(new Step(i++, "Finish"));
    }

    public Step getStep(){
        return steps.get(j);
    }

    public Step getNextStep(){
        while (j+1<steps.size()) {
            return steps.get(++j);
        }
        return steps.get(steps.size()-1);
    }
}
