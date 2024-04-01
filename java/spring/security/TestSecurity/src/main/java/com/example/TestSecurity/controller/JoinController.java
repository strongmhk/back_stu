package com.example.TestSecurity.controller;

import com.example.TestSecurity.dto.JoinDto;
import com.example.TestSecurity.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        log.info("username = {}", joinDto.getUsername());
        log.info("password = {}", joinDto.getPassword());
        return "redirect:/login";
    }
}
