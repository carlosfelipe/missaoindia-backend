package com.missaoindia.quiz.showmilhao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@Entity(name = "Alternative")
public class Alternative {

    @Id
    private Integer idAlternative;
    private Integer indexOption;
    private String descOption;
    private Boolean optionCorrect;

}
