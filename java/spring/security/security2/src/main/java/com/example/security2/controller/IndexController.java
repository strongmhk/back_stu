package com.example.security2.controller;

import com.example.security2.domain.User;
import com.example.security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping({"", "/"})
    public String index() {
        // mustache 기본 경로 : src/main/resources/
        // ViewResolver 설정 : templates (prefix) , mustache(suffix) - 생략 가능
        return "index";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    @ResponseBody
    public String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPwd = user.getPassword();
        String encPwd = passwordEncoder.encode(rawPwd);
        user.setPassword(encPwd);
        userRepository.save(user); // 회원가입 잘되지만, 비밀번호가 암호화되지 않고 그대로 저장돼 시큐리티로 로그인이 불가능
        return "redirect:/loginForm";
    }

    @GetMapping("/info")
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public String info() {
        return "개인정보";
    }

    @GetMapping("/data")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String data() {
        return "데이터";
    }




}
