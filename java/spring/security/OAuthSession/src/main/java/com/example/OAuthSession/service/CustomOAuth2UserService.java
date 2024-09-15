package com.example.OAuthSession.service;

import com.example.OAuthSession.dto.CustomOAuth2User;
import com.example.OAuthSession.dto.GoogleResponse;
import com.example.OAuthSession.dto.NaverResponse;
import com.example.OAuthSession.dto.OAuth2Response;
import com.example.OAuthSession.entity.UserEntity;
import com.example.OAuthSession.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

//DefaultOAuth2UserService: OAuth2UserService의 구현체
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("oAuth2User: {}", oAuth2User.getAttributes());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        } else if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else {
            return null;
        }

        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();
        UserEntity existUser = userRepository.findByUsername(username);

        // 신규 회원의 경우 새로운 role 지정이 필요하기 때문에 초기값이 null이면 안됨
        String role = "ROLE_USER";

        // 새로운 회원인 경우
        if (existUser == null) {
            // 새로운 회원 정보 DB에 저장
            UserEntity newUser = UserEntity.builder()
                    .username(username)
                    .email(oAuth2Response.getEmail())
                    .role(role)
                    .build();

            userRepository.save(newUser);
        } else {
            existUser.updateUserInfo(username, oAuth2Response.getEmail());
            role = existUser.getRole();

            userRepository.save(existUser);
        }

        return new CustomOAuth2User(oAuth2Response, role);

    }
}