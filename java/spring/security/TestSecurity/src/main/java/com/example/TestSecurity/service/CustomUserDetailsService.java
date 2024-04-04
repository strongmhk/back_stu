package com.example.TestSecurity.service;

import com.example.TestSecurity.dto.CustomUserDetails;
import com.example.TestSecurity.entity.User;
import com.example.TestSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    // 클라이언트에서 로그인 요청 -> SecurityConfig가 loadUserByUsername 메서드 호출(인자에는 요청으로 받은 username 넣어줌)
    // DB에서 username을 기반으로 회원을 찾음
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userData = userRepository.findByUsername(username);

        if (userData != null) {
            return new CustomUserDetails(userData); // DB에서 가져온 user의 정보를 UserDetails를 구현한 클래스에 저장
        }
        return null;
    }
}
