package com.sqc.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sqc
 */
@RestController()
public class TestController {
    @GetMapping("/test")
    public String testHello(){
        return "hello";
    }
}
