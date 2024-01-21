package com.example.security2.auth;

import com.example.security2.domain.User;
import com.example.security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 .loginProcessingUrl("login")
// /login으로 요청이 오면 UserDetailsService 타입으로 IoC 되어있는 빈의 loadUserByUsername 함수가 호출됨.
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티 session 내부 => Authentication 내부 => UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            // UserDetails 타입 객체를 반환하면 Authentication 객체에 담고 다시 시큐리티 session 안에 Authentication 객체를 담는다.
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
