package com.myapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String value;
    @JsonIgnore
    @ManyToOne
    private Question question;
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="stat_id")
    private Stat stat;

    public Answer(){}

    public Answer(Long id, String value, Question question, Stat stat){
        this.setId(id);
        this.setValue(value);
        this.setQuestion(question);
        this.setStat(stat);
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

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}