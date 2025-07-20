package com.urugondavishnu.store.controllers;

import com.urugondavishnu.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @RequestMapping("/hello")
    public Message sayhello(){
        return new Message("Hello World!");
    }

}
