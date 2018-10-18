package com.myapp.resource;

import com.myapp.entity.Answer;
import com.myapp.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
public class AnswerResource {

    public AnswerResource (AnswerService answerSerice){
        this.answerService = answerSerice;
    }
    private AnswerService answerService ;

    @RequestMapping("/answers")
    public List<Answer> getAll(){
        return answerService.getAll();
    }

    @PostMapping("/answers")
    public Answer create(@RequestBody Answer answer){
        return answerService.create(answer);
    }

    @RequestMapping(method = GET, path = "/answers/{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id) {
        Optional<Answer> answer = answerService.findById(id);
        return answer.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
