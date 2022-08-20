package com.missaoindia.quiz.showmilhao.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "AnswerAlternative")
public class AnswerAlternative {

    @Id
    @GeneratedValue
    private Long idAnswerAlternative;
    private String descAlternative;
    private Boolean alternativeCorrect;

//    @ManyToOne
//    private Long idQuestion;

}
