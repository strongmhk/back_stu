package com.cos.security1.auth;

import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


// 시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어있는 loadUserByUsername 함수가 실행됨 => 규칙
// 만약 로그인할 때 받는 필드값이 username이 아니고, name이라면 SecurityConfig에서 .usernameParameter("name")을 추가해줘야함
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // 시큐리티 session에 저장될 수 있는 객체 타입 = Authentication
    // loadByUsername이 실행돼 UserDetails타입의 객체가 return되면 그 객체는 Security 세션 내부에 있는 Authentication 객체의 내부에 들어가고
    // 그 내부의 객체는 다시 시큐리티 Session값으로 들어간다
    // 정리 : Security Session(내부 Authentication(내부 UserDetails))

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        User userEntity = userRepository.findByUsername(username);
        System.out.println("userEntity = " + userEntity);
        if(userEntity != null){
            return new PrincipalDetails(userEntity);
        }

        return null;
    }
}
