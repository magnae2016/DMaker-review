package com.spring.dmaker.review.controller;

import com.spring.dmaker.review.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/create-developers")
    public String createDevelopers() {
        log.info("/create-developers");

        dMakerService.createDeveloper();

        return "Olaf";
    }
}
