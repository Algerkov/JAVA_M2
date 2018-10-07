package com.myapp.repository;

import com.myapp.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepoInterface extends JpaRepository<Answer, Long> {
}
