package com.spcbrasil.api.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
@RequestMapping("msgs")
public class MessageController {

//users-ws/msgs/message

    @Autowired
    private Environment environment;

    @RequestMapping("/message")
    String getMessage() {
       return environment.getProperty("api.chave");
    }

}
