package com.myapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String value;
    @ManyToOne
    private Question question;

    public Answer(){}

    public Answer(Long id, String value, Question question){
        this.setId(id);
        this.setValue(value);
        this.setQuestion(question);
    }

    public Answer(Long id, String value){
        this.setId(id);
        this.setValue(value);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}