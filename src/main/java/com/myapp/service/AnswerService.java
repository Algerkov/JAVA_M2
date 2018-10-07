package com.myapp.service;

import com.myapp.entity.Answer;
import com.myapp.repository.AnswerRepo;
import com.myapp.repository.AnswerRepoInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    AnswerRepoInterface answerRepository ;

    public AnswerService(AnswerRepoInterface answerRepo){
        answerRepository = answerRepo;
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }
    public void create(String answer){
        answerRepository.save(new Answer(answer));
    }
}
