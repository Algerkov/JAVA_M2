package com.myapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "stat")
public class Stat {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Answer answer;
    private Integer nbAnswers;

    public Stat(){}
    public Stat(Long id, Answer Answer, Integer nbAnswers){
        this.setId(id);
        this.setAnswer(answer);
        this.setNbAnswers(nbAnswers);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Integer getNbAnswers() {
        return nbAnswers;
    }

    public void setNbAnswers(Integer nbAnswers) {
        this.nbAnswers = nbAnswers;
    }
}