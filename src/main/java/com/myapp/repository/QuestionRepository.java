package com.myapp.repository;

import com.myapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Override
    List<Question> findAll();

    @Override
    <S extends Question> S save(S s);

    @Override
    Optional<Question> findById(Long aLong);

    @Override
    <S extends Question> List<S> saveAll(Iterable<S> entities);
}
