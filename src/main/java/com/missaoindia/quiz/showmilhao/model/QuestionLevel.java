package com.missaoindia.quiz.showmilhao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
public class QuestionLevel {

    @Id
    private Integer level;
    private Long score;
}
