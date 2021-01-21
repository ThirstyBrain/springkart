package com.thirstybrain.springkart.identityservice.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/rest/identities")
public class IdentityController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("")
    public String getIdentities(){
        return "Identities";
    }
}
