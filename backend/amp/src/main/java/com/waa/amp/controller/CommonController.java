package com.waa.amp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/common")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class CommonController {

    @GetMapping("/student-search")
    public ResponseEntity<?> studentSearch(@RequestParam Map<String, String> param) {

        return null;
    }

}
