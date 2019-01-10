package com.myapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "stat")
public class Stat {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Integer nbAnswers;

    public Stat(){}
    public Stat(Long id, Integer nbAnswers){
        this.setId(id);
        this.setNbAnswers(nbAnswers);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbAnswers() {
        return nbAnswers;
    }

    public void setNbAnswers(Integer nbAnswers) {
        this.nbAnswers = nbAnswers;
    }
}