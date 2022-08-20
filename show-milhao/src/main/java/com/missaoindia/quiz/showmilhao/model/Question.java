package com.missaoindia.quiz.showmilhao.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuestion;
    private String descQuestion;
    private Integer level;
    private Integer score;
    @Column(columnDefinition = "boolean default false")
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AnswerAlternative> answers;

}
