package com.example.OAuthJWT.service;

import com.example.OAuthJWT.dto.GoogleResponse;
import com.example.OAuthJWT.dto.NaverResponse;
import com.example.OAuthJWT.dto.OAuth2Response;
import com.example.OAuthJWT.dto.UserDTO;
import com.example.OAuthJWT.entity.User;
import com.example.OAuthJWT.oauth2.CustomOAuth2User;
import com.example.OAuthJWT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("OAuth2User : {}", oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        //리소스 서버에서 발급 받은 정보로 사용자를 특정할 아이디값을 만듬
        String username = oAuth2Response.getProvider()+" "+oAuth2Response.getProviderId();
        User existUser = userRepository.findByUsername(username);

        // user가 존재하지 않는 경우
        if (existUser == null) {
            User newUser = User.builder()
                    .username(username)
                    .email(oAuth2Response.getEmail())
                    .name(oAuth2Response.getName())
                    .role("ROLE_USER")
                    .build();

            userRepository.save(newUser);

            UserDTO userDTO = UserDTO.builder()
                    .username(username)
                    .name(oAuth2Response.getName())
                    .role("ROLE_USER")
                    .build();

            return new CustomOAuth2User(userDTO);
        } else {   // user가 존재하는 경우
            existUser.updateUserInfo(existUser.getEmail(), oAuth2Response.getName());
            userRepository.save(existUser);

            UserDTO userDTO = UserDTO.builder()
                    .username(existUser.getUsername())
                    .name(oAuth2Response.getName())
                    .role(existUser.getRole())
                    .build();

            return new CustomOAuth2User(userDTO);
        }

    }
}