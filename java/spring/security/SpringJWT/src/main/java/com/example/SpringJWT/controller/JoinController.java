package com.example.SpringJWT.controller;

import com.example.SpringJWT.dto.JoinDto;
import com.example.SpringJWT.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(@RequestBody JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        return "ok";
    }


}
