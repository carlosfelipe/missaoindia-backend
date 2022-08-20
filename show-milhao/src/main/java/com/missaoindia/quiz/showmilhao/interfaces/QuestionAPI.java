package com.missaoindia.quiz.showmilhao.interfaces;

import com.missaoindia.quiz.showmilhao.model.Alternative;
import com.missaoindia.quiz.showmilhao.model.Question;
import com.missaoindia.quiz.showmilhao.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionAPI {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> listQuestions(){
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Question findQuestion(@PathVariable("id") Long id){
        return questionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND
        ));
    }

    @GetMapping("/questions/level/{level}")
    public Question findQuestionByLevel(@PathVariable("level") Integer level){
        return questionRepository.findByLevel(level);
    }

    @GetMapping("/questions/allLevel/{level}/{active}")
    public List<Question> findAllQuestionsByLevel(@PathVariable("level") Integer level,
                                                  @PathVariable("active") Boolean active) {
        return questionRepository.findByLevelAndActive(level, active);
    }


//    @PutMapping("/questions/{id}")
//    public Question fullUpdateQuestion(@PathVariable("id") Long id, @RequestBody Question question){
//        Question questionDB = findQuestion(id);
//        questionDB.setDescQuestion(question.getDescQuestion());
//        questionDB.setLevel(question.getLevel());
//        questionDB.setActive(question.getActive());
//        questionDB.setIdQuestion(question.getIdQuestion());
//        return questionRepository.save(questionDB);
//    }

    @PatchMapping("/questions/{id}")
    public Question updateQuestion(@PathVariable("id") Long id, @RequestBody Question questionReq){
        Question questionDB = findQuestion(id);
        questionDB.setLevel(Optional.ofNullable(questionReq.getLevel())
                .orElse(questionDB.getLevel()));
        questionDB.setDescQuestion(Optional.ofNullable(questionReq.getDescQuestion())
                .orElse(questionDB.getDescQuestion()));
        questionDB.setActive(Optional.ofNullable(questionReq.getActive())
                .orElse(questionReq.getActive()));
        questionDB.setScore(Optional.ofNullable(questionReq.getScore())
                .orElse(questionReq.getScore()));
        return questionRepository.save(questionDB);
    }

    @PostMapping("/questions")
    public Question createQuestion(@RequestBody Question question){
        return questionRepository.save(question);
    }

}
