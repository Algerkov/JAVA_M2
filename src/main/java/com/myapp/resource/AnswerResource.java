package com.myapp.resource;

import com.myapp.entity.Answer;
import com.myapp.service.AnswerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController()
public class AnswerResource {

    public AnswerResource (AnswerService answerSerice){
        this.answerService = answerSerice;
    }
    private AnswerService answerService ;

    @RequestMapping("/answers")
    public List<Answer> getAll(){
        return answerService.getAll();
    }

    @PostMapping("/answers")
    public void create(@RequestBody String answer){
        answerService.create(answer);
    }
}
