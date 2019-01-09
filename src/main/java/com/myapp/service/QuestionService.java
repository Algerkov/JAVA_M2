package com.myapp.service;

import com.myapp.entity.Question;
import com.myapp.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    QuestionRepository QuestionRepository ;

    public QuestionService(QuestionRepository QuestionRepo){
        QuestionRepository = QuestionRepo;
    }

    public List<Question> getAll() {
        return QuestionRepository.findAll();
    }

    public Question create(Question Question){
        return QuestionRepository.save(Question);
    }

    public Optional<Question> findById(Long id) {
        return QuestionRepository.findById(id);
    }
}
