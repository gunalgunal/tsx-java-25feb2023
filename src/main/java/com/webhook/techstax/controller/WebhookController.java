package com.webhook.techstax.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.webhook.techstax.connector.RestApiConnector;
import com.webhook.techstax.entity.GithubResponse;
import com.webhook.techstax.exception.BindingException;
import com.webhook.techstax.jsontoclass.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {
    @Value("${techstax.github.api}")
    private String githubApiUrl;
   private Logger logger= LoggerFactory.getLogger(WebhookController.class);
   @Autowired
   private RestApiConnector restApiConnector;
   //api to tracks push, pull, and merge events in the Github
    @PostMapping("/webhook")
    public ResponseEntity<String> getDataFromGithub(@RequestBody String data)
    {
        logger.info("webhook:"+data);
        return new ResponseEntity<String>(data, HttpStatus.OK);
    }


   //api to retrieve list of commits from the githup api
    @GetMapping("/github/list/commits")
    public GithubResponse[] getListOfCommits() throws JsonProcessingException {
        String response=restApiConnector.callService(githubApiUrl);
        logger.info("list of commits"+response.toString());
        GithubResponse[] githubResponses;
        try{
             githubResponses= CommonUtils.newObjectMapper().readValue(response, GithubResponse[].class);

        }
        catch(Exception e)
        {
            throw new BindingException("error in binding");
        }

        return githubResponses;
    }
}
