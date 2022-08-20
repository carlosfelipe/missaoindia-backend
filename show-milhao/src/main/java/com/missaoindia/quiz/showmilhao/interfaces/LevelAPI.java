package com.missaoindia.quiz.showmilhao.interfaces;

import com.missaoindia.quiz.showmilhao.model.Question;
import com.missaoindia.quiz.showmilhao.model.QuestionLevel;
import com.missaoindia.quiz.showmilhao.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LevelAPI {

    @Autowired
    LevelRepository levelRepository;

    @GetMapping("/levels")
    public List<QuestionLevel> getLevelsQuiz(){
        return levelRepository.findAll();
    }

    @PostMapping("/levels")
    public QuestionLevel createLevel(@RequestBody QuestionLevel questionLevel){
        return levelRepository.save(questionLevel);
    }

}
