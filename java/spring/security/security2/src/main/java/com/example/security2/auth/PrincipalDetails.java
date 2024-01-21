package com.example.security2.auth;

import org.springframework.security.core.GrantedAuthority;
import com.example.security2.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인 진행이 완료가 되면 시큐리티 session을 만들어준다. -> Key(Security ContextHolder) : value(session값) 으로 저장
// 이 session안에 들어가는 것이 Authentication 타입의 객체이다.


// 결론 : 스프링 시큐리티를 통한 로그인 진행이 완료가 되면 Security Session을 Security ContextHolder 안에 저장하며,
// 이 Security Session 안에는 Authentication 타입의 객체가 들어가고,
// Authentication 안에는 로그인한 유저에 대한 정보인 UserDetails 객체가 존재한다.
// 즉, Spring Security => Authentication => UserDetails 흐름으로 객체가 존재한다.

public class PrincipalDetails implements UserDetails {

    private User user; // 컴포지션

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 해당 User의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        // 1년동안 회원이 로그인을 안하면 휴면계정으로 전환
        // 현재시간 - 로그인시간 => 1년 초과시 return false;

        return true;
    }
}
