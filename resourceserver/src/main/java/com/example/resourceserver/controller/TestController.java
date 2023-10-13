package com.example.resourceserver.controller;

import com.example.resourceserver.service.TestService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

//    @GetMapping("/test")
//    Map<String, String> test(@AuthenticationPrincipal Jwt jwt) {
//        return Map.of("content", "Hello, " + jwt.getSubject());
//    }

    @GetMapping("/")
    Map<String, String> test() {
        return testService.test();
    }
}
