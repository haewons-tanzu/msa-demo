package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hwshin
 */

@RefreshScope
@RestController
public class DemoController {
    @Value("${greeting}")
    String message;

    @Autowired
    DemoCommand4 demoCommand;

    @RequestMapping("/")
    public String test() {
        return "Hello, I'm app 1. " + message;
    }

    @RequestMapping("/demoapp1")
    public String test2() {
        return "Hello, I'm demo-app 1. " + message;
    }

    @RequestMapping("/start")
    public String hello(@RequestParam(value="number", defaultValue="3") Integer number, @RequestParam(value="maxIter", defaultValue="10") Integer maxIter,
                        @RequestParam(value="invoked", defaultValue="true") String invoked) {
        return demoCommand.invoke4(number, maxIter, message, invoked);
        //return "Hello, I'm app 1. " + message;
    }
}
