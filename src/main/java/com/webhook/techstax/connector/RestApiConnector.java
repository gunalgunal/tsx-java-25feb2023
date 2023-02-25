package com.webhook.techstax.connector;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RestApiConnector {

    private RestTemplate restTemplate;

    public RestApiConnector(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate=restTemplateBuilder.build();
    }


    public String callService(String url)
    {
        return this.restTemplate.getForObject(url,String.class);

    }
}
