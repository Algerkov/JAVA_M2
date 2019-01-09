package com.myapp.repository;

import com.myapp.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {
    @Override
    List<Stat> findAll();

    @Override
    <S extends Stat> S save(S s);

    @Override
    Optional<Stat> findById(Long aLong);

    @Override
    <S extends Stat> List<S> saveAll(Iterable<S> entities);
}
