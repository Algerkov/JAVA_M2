package com.myapp.service;

import com.myapp.entity.Stat;
import com.myapp.repository.StatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatService {

    StatRepository StatRepository ;

    public StatService(StatRepository StatRepo){
        StatRepository = StatRepo;
    }

    public List<Stat> getAll() {
        return StatRepository.findAll();
    }

    public Stat create(Stat Stat){
        return StatRepository.save(Stat);
    }

    public Optional<Stat> findById(Long id) {
        return StatRepository.findById(id);
    }
}
