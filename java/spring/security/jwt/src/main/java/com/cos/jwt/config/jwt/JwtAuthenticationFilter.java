package com.cos.jwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwt.config.auth.PrincipalDetails;
import com.cos.jwt.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

// 스프링 시큐리티에 UsernamePasswordAuthenticationFilter가 있음.
// /login 요청해서 username, password 전송하면 (post)
// UsernamePasswordAuthenticationFilter가 동작을 함 -> SecurityConfig에서 formLogin().disable()하면 동작안함
// SecurityConfig에서 addFilter해주면 다시 동작함

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // /login 요청을 하면 로그인 시도를 위해서 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter : 로그인 시도 중");

        // 1. username, password를 받아서
        // 2. 정상인지 로그인 시도를 해보기. authenticationManager로 로그인 시도를 하면!! PrincipalDetailsService가 호출
        // PrincipalDetailsService가 호출, loadUserByUsername() 함수 실행됨
        // 정상적으로 PrincipalDetails가 리턴되면

        // 3. PrincipalDetails를 세션에 담고 (권한 관리를 위해서)

        // 4. JWT 토큰을 만들어서 응답해주면 됨.
        try {
//            BufferedReader br = request.getReader();
//
//            String input = null;
//            while((input = br.readLine()) != null){
//                System.out.println(input);
//            }
            ObjectMapper om = new ObjectMapper(); // json 데이터를 파싱해주는 객체
            User user = om.readValue(request.getInputStream(), User.class); // 요청 데이터(json) user object에 담아주기
            System.out.println(user);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            // PrincipalDetailsService의 loadByUsername() 함수가 실행된 후 정상이면 authentication이 리턴됨.
            //  authentication이 리턴된다는건 DB에 있는 username과 password가 일치한다는 것
            // authenticationManager에 토큰을 넣어서 실행시키면 로그인한 정보를 리턴 (authentication에 로그인한 정보를 객체로 리턴)
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            // principalDetails가 출력된다는건 로그인이 되었다는 뜻
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal(); // downcasting
            System.out.println("로그인 완료됨 : " + principalDetails.getUser().getUsername()); // principalDetails.getUser()하려면 @Data 붙여줘야함(getter, setter 생성)
            // 출력이 된다는 건 로그인이 정상적으로 되었다는 뜻
            // 로그인이 됐으면 authentication 객체를 session 영역에 저장해야하고 저장하는 방법은 리턴을 이용
            // 리턴의 이유는 권한 관리를 security가 대신 해주기 때문에 편하려고 하는거임
            // 굳이 jwt 토큰을 사용하면서 세션을 만들 이유가 없음. 근데 단지 권한 처리때문에 session 넣어줍니다.

            System.out.println("1======================================");
            return authentication; // return 될 때 authentication 객체가 세션 영역에 저장됨
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("2======================================");


        return null; // 오류가 나면 null 리턴
    }

    // attemptAuthentication 실행 후 인증이 정상적으로 되었으면 successfulAuthentication 함수가 실행됨
    // JWT 토큰을 만들어서 request 요청한 사용자에게 JWT 토큰을 response 해주면됨
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication 실행됨 : 인증이 완료되었다는 뜻임.");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        // RSA방식은 아니고 Hash 암호방식
        String jwtToken = JWT.create()
                .withSubject("cos토큰")
                        .withExpiresAt(new Date(System.currentTimeMillis()+(60000 * 10))) // 60000이면 60초
                                .withClaim("id", principalDetails.getUser().getId())
                                        .withClaim("username", principalDetails.getUser().getUsername())
                                                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken); // Bearer 뒤에 한 칸 반드시 띄어야함
    }
}


// 세션을 사용하는 방식
// 1. username, password 로그인 정상
// 2. 서버쪽 세션 ID 생성
// 3. 서버가 클라이언트쪽 쿠키로 세션 ID를 응답해줌
// 4. 클라이언트가 요청할 때는 쿠키값 세션 ID를 항상 들고 서버쪽으로 요청하기 때문에
// 5. 서버는 세션ID가 유효한지 판단해서 유효하면 인증이 필요한 페이지로 접근하게 하면 됨


// JWT 토큰을 사용하는 방식
// 1. username, password 로그인 정상
// 2. JWT 토큰 생성
// 3. 클라이언트 쪽으로 JWT토큰을 응답해줌
// 4. 요청할 때마다 JWT 토큰을 요청
// 5. 서버는 JWT 토큰이 유효한지 판단(필터를 통해 해야함, 그래서 이 필터(JwtAuthorizationFilter)를 만들어야함)