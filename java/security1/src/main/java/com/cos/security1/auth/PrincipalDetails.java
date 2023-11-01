package com.cos.security1.auth;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인 진행이 완료가 되면 시큐리티 session을 만들어준다. 일반 세션이 아니고 시큐리티 자신만의 세션 공간(Security ContextHolder에 저장)의 key값에 세션값을 저장
// 시큐리티가 가지고 있는 세션에 들어갈 수 있는 오브젝트가 정해져있음 => Authentication 타입 객체
// Authentication안에 User 정보가 있어야 됨.
// User 오브젝트 타입 => UserDetails 타입 객체

// Security Session => Authentication => UserDetails(PrincipalDetails, Authentication안에 유저 정보를 저장하는 객체)

// 정리 : UserDetails타입의 PrincipalDetails 객체를 만들고, 그 객체를 Authentication 객체안에 넣어 시큐리티 세션값에 저장해야함

import com.cos.security1.model.User;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private User user; // 콤포지션

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 해당 User의 권한을 리턴하는 곳!!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
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

        // 우리 사이트!! 1년동안 회원이 로그인을 안하면!! 휴면 계정으로 하기로 함
        // 현재시간 - 로그인시간 => 1년을 초과하면 return false;

        return true;
    }
}
