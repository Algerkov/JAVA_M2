package com.myapp.service;

import com.myapp.entity.Answer;
import com.myapp.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    AnswerRepository answerRepository ;

    public AnswerService(AnswerRepository answerRepo){
        answerRepository = answerRepo;
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public Answer create(Answer answer){
        return answerRepository.save(answer);
    }

    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }
}
