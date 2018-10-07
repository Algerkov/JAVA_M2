package com.myapp.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AnswerRepo {
    private final Map<Integer, String> DATABASE ;

    public AnswerRepo(){
        DATABASE = new HashMap<Integer, String>();
    }

    public List<String> getAll(){
        return DATABASE.values().stream().collect(Collectors.toList());
    }

    public void create (String answer){
        DATABASE.put(DATABASE.keySet().size(), answer);

    }
}
