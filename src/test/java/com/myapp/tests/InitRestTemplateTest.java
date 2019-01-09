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

public class InitRestTemplateTest extends AbstractPackagerViewTest {

    @Test
    public void init(){
        ResponseEntity<Answer> response = restTemplate.exchange(
                baseUrl + "/init/",
        GET, null, Answer.class);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
