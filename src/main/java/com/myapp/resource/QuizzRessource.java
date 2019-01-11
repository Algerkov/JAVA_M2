package com.myapp.resource;

import com.myapp.classes.Quizz;
import com.myapp.entity.Answer;
import com.myapp.entity.Question;
import com.myapp.entity.Stat;
import com.myapp.entity.User;
import com.myapp.service.AnswerService;
import com.myapp.service.QuestionService;
import com.myapp.service.StatService;
import com.myapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
public class QuizzRessource {

    public QuizzRessource(AnswerService answerSerice, QuestionService questionService, StatService statService, UserService userService){
        this.answerService = answerSerice;
        this.questionService = questionService;
        this.statService = statService;
        this.userService = userService;
        this.quizz = new Quizz(questionService);
    }
    private final AnswerService answerService ;
    private final QuestionService questionService;
    private final StatService statService;
    private final UserService userService;
    private final Quizz quizz;

    @RequestMapping(method = GET, path = "/presentateur")
    public ResponseEntity presentateurData() {
        return ResponseEntity.ok().body(quizz.getStep());
    }

    @RequestMapping(method = GET, path = "/public")
    public ResponseEntity publicData() {
        return ResponseEntity.ok().body(quizz.getStep());
    }

    @RequestMapping(method = GET, path = "/presentateur/next")
    public ResponseEntity nextData() {
        return ResponseEntity.ok().body(quizz.getNextStep());
    }

    @RequestMapping(method = GET, path = "/public/answer/{id}")
    public ResponseEntity answer(@PathVariable("id") long id) {

        Optional<Answer> ansA = answerService.findById(id);
        Answer ans = ansA.get();
        boolean goodQuestion = false;
        
        for (Answer anss : quizz.getStep().getQuestion().getAnswers()){
            if (anss.getId() == ans.getId()){
                goodQuestion = true;
            }
        }
        
        if (goodQuestion) {
            Stat stat = ans.getStat();
            Integer nbAnswer = stat.getNbAnswers();
            stat.setNbAnswers(nbAnswer + 1);
            statService.create(stat);
            return ResponseEntity.ok().body("Vote enregistré");
        }
        else {
            return ResponseEntity.ok().body("Erreur: question passée");
        }
    }

    @PostMapping("/newsletter")
    public User create(@RequestBody User user){
        return userService.create(user);
    }
}
