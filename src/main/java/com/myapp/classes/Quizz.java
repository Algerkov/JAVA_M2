package com.myapp.classes;

import com.myapp.entity.Question;
import com.myapp.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

public class Quizz {
    private List<Step> steps;
    private int j=0;
    private QuestionService questionService;

    public Quizz(QuestionService questionService){
        this.questionService = questionService;
        int i=0;
        steps = new ArrayList<Step>();
        steps.add(new Step(i, "Init"));

        for(Question question : questionService.getAllById()) {
            steps.add(new Step(++i, "Question", question));
        }

        steps.add(new Step(i++, "Finish"));
    }

    public Step getStep(){
        Step step = steps.get(j);
        step.updateStep(questionService);
        return step;
    }

    public Step getNextStep(){
        Step step;
        while (j+1<steps.size()) {
            step = steps.get(++j);
            step.updateStep(questionService );
            return step;
        }
        return steps.get(steps.size()-1);
    }
}
