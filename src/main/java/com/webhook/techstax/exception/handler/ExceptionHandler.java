package com.webhook.techstax.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webhook.techstax.exception.BindingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {



    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(BindingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleRegionNotFoundException(BindingException r)
    {
        return Map.of("message",r.getLocalizedMessage());
    }
}
