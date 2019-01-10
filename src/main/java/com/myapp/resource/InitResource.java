package com.myapp.resource;

import com.myapp.entity.Answer;
import com.myapp.entity.Question;
import com.myapp.entity.Stat;
import com.myapp.service.AnswerService;
import com.myapp.service.QuestionService;
import com.myapp.service.StatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
public class InitResource {

    public InitResource(AnswerService answerSerice, QuestionService questionService, StatService statService){
        this.answerService = answerSerice;
        this.questionService = questionService;
        this.statService = statService;
    }
    private AnswerService answerService ;
    private QuestionService questionService;
    private StatService statService;

    @RequestMapping(method = GET, path = "/init")
    public ResponseEntity initQuestions() {

        List<Answer> allAnswers = new ArrayList<Answer>();
        List<Question> allQuestions = new ArrayList<Question>();
        List<Stat> allStats = new ArrayList<Stat>();

        Answer ans1 = new Answer (null, "OUI");allAnswers.add(ans1);
        Answer ans2 = new Answer(null, "NON");allAnswers.add(ans2);
        Answer ans3 = new Answer (null, "OUI");allAnswers.add(ans3);
        Answer ans4 = new Answer(null, "NON");allAnswers.add(ans4);
        Answer ans5 = new Answer (null, "10[bitcoin]");allAnswers.add(ans5);
        Answer ans6 = new Answer(null, "100[bitcoin]");allAnswers.add(ans6);
        Answer ans7 = new Answer(null, "1000[bitcoin]");allAnswers.add(ans7);
        Answer ans8 = new Answer(null, "Innovation");allAnswers.add(ans8);
        Answer ans9 = new Answer (null, "Gagner la guerre");allAnswers.add(ans9);
        Answer ans10 = new Answer(null, "Gagner au loto");allAnswers.add(ans10);
        Answer ans11 = new Answer(null, "Connaitre son avenir");allAnswers.add(ans11);
        Answer ans12 = new Answer(null, "Corriger le passé");allAnswers.add(ans12);
        Answer ans13 = new Answer(null, "BRAVO");allAnswers.add(ans13);

        for (Answer ans : allAnswers){
            answerService.create(ans);
        }

        Stat stat1 = new Stat(null, 0);allStats.add(stat1);
        Stat stat2 = new Stat(null, 0);allStats.add(stat2);
        Stat stat3 = new Stat(null, 0);allStats.add(stat3);
        Stat stat4 = new Stat(null, 0);allStats.add(stat4);
        Stat stat5 = new Stat(null, 0);allStats.add(stat5);
        Stat stat6 = new Stat(null, 0);allStats.add(stat6);
        Stat stat7 = new Stat(null, 0);allStats.add(stat7);
        Stat stat8 = new Stat(null, 0);allStats.add(stat8);
        Stat stat9 = new Stat(null, 0);allStats.add(stat9);
        Stat stat10 = new Stat(null, 0);allStats.add(stat10);
        Stat stat11 = new Stat(null, 0);allStats.add(stat11);
        Stat stat12 = new Stat(null, 0);allStats.add(stat12);
        Stat stat13 = new Stat(null, 0);allStats.add(stat13);

        for (Stat stat : allStats){
            statService.create(stat);
        }

        List<Answer> list1 = new ArrayList<Answer>();
        List<Answer> list2 = new ArrayList<Answer>();
        List<Answer> list3 = new ArrayList<Answer>();
        List<Answer> list4 = new ArrayList<Answer>();
        List<Answer> list5 = new ArrayList<Answer>();

        list1.add(ans1);
        list1.add(ans2);

        list2.add(ans3);
        list2.add(ans4);

        list3.add(ans5);
        list3.add(ans6);
        list3.add(ans7);

        list4.add(ans8);
        list4.add(ans9);
        list4.add(ans10);
        list4.add(ans11);
        list4.add(ans12);

        list5.add(ans13);

        Question q1  = new Question("Croyez-vous qu’il sera possible un jour de connaître l’avenir, de modifier le passé ?", list1);allQuestions.add(q1);
        Question q2  = new Question("Voudriez-vous un jour voyager à travers une faille temporelle et retourner à l’époque où le LOSC était en Ligue 1 ? ", list2);allQuestions.add(q2);
        Question q3  = new Question("Quel prix seriez-vous prêt à débourser pour discuter avec vos ancêtres ?", list3);allQuestions.add(q3);
        Question q4  = new Question("Quelle est la raison principale pour laquelle ce genre de technologie doit voir le jour ?", list4);allQuestions.add(q4);
        Question q5  = new Question("Donner le mot qui résume pour vous cette technologie", list5);allQuestions.add(q5);

        for (Question question : allQuestions){
            questionService.create(question);
        }

        for (Answer ans : list1){
            ans.setQuestion(q1);
            answerService.create(ans);
        }

        for (Answer ans : list2){
            ans.setQuestion(q2);
            answerService.create(ans);
        }

        for (Answer ans : list3){
            ans.setQuestion(q3);
            answerService.create(ans);
        }

        for (Answer ans : list4){
            ans.setQuestion(q4);
            answerService.create(ans);
        }

        for (Answer ans : list5){
            ans.setQuestion(q5);
            answerService.create(ans);
        }

        ans1.setStat(stat1);
        ans2.setStat(stat2);
        ans3.setStat(stat3);
        ans4.setStat(stat4);
        ans5.setStat(stat5);
        ans6.setStat(stat6);
        ans7.setStat(stat7);
        ans8.setStat(stat8);
        ans9.setStat(stat9);
        ans10.setStat(stat10);
        ans11.setStat(stat11);
        ans12.setStat(stat12);
        ans13.setStat(stat13);

        for (Answer ans : allAnswers){
            answerService.create(ans);
        }

        return ResponseEntity.ok().body("C'est initilisé ");
    }
}
