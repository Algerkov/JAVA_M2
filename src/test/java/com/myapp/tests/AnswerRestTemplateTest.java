package com.myapp.tests;

import com.myapp.entity.Answer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.fail;
import static org.springframework.http.HttpMethod.GET;

public class AnswerRestTemplateTest extends AbstractPackagerViewTest {

    @Test
    public void foundAnswer(){
        Long expectedId = 1L;
        ResponseEntity<Answer> response = restTemplate.exchange(
                baseUrl + "/answers/" + expectedId,
        GET, null, Answer.class);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getId()).isEqualTo(expectedId);
    }

    @Test
    public void answerNotFound() {
        try {
            restTemplate.exchange(
                    baseUrl + "/answers/"+ (MAX_ELEMENT + 1),
            GET,
            null,
            Answer.class);
            fail("Should throw 404 error");
        } catch (HttpClientErrorException e){
            Assertions.assertThat(e).isNotNull();
            Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        }
    }
}
