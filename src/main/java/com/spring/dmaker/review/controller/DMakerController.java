package com.spring.dmaker.review.controller;

import com.spring.dmaker.review.dto.CreateDeveloper;
import com.spring.dmaker.review.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        log.info("/developers");

        return Arrays.asList("snow", "Elsa", "Olaf");
    }

    @PostMapping("/create-developers")
    public String createDevelopers(@Valid @RequestBody CreateDeveloper.Request request) {
        log.info("request : {}", request);

        dMakerService.createDeveloper(request);

        return "Olaf";
    }
}
