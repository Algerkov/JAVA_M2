package com.myapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String answer;

    protected Answer() {}

    public Answer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return String.format(
                "Answer[id=%d, answer='%s']",
                id, answer);
    }

}