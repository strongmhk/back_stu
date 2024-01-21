package com.example.security2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    // @Bean : 해당 메서드의 리턴되는 객체를 IoC 컨테이너에 등록함.
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable);
        http.authorizeHttpRequests(authorize ->
                authorize
                        .requestMatchers("/user/**").hasAnyRole("USER", "MANAGER", "ADMIN") // "/user" 이하의 경로 모두 인증 필요함
                        .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") // 권한 필요
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")

                        .anyRequest().permitAll()
        )
                .formLogin(login -> login
                        .loginPage("/loginForm")
                        .loginProcessingUrl("/login") // /login이 호출되면 시큐리티가 낚아채서 대신 로그인을 진행해줌
                        .defaultSuccessUrl("/", true)
//                        .usernameParameter("name") // loadByUsername 함수에 바인딩 되는 파라미터 이름을 바꾼다.
                        .permitAll()
                )

                .logout(Customizer.withDefaults());

        return http.build();
    }

}
