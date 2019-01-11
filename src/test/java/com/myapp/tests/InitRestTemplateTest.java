package com.myapp.tests;

import com.myapp.entity.Answer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;

import javax.xml.ws.Response;

import static org.junit.Assert.fail;
import static org.springframework.http.HttpMethod.GET;

public class InitRestTemplateTest extends AbstractPackagerViewTest {

    @Test
    public void init(){
       ResponseEntity response = restTemplate.exchange(
                baseUrl + "/init/",
        GET, ResponseEntity.ok().body("C'est initilisé"), String.class);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
