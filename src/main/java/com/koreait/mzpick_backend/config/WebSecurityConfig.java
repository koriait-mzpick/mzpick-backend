package com.koreait.mzpick_backend.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.filter.JwtAuthenticationFilter;
import com.koreait.mzpick_backend.handler.OAuth2SuccessHandler;
import com.koreait.mzpick_backend.service.implement.auth.OAuth2UserServiceImplement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

// Spring Security 설정을 위한 어노테이션 //
@Configurable
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    // OAuth2 인증 성공 핸들러 //
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    // JWT 인증 필터 //
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    // OAuth2 사용자 서비스 구현체 //
    private final OAuth2UserServiceImplement oAuth2Service;

    // Security Filter Chain 설정 Bean //
    @Bean
    protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
        security
            // HTTP Basic 인증 비활성화 //
            .httpBasic(HttpBasicConfigurer::disable)
            // 세션 관리 설정 - STATELESS로 설정하여 세션을 사용하지 않음 //
            .sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // CSRF 보안 비활성화 //    
            .csrf(CsrfConfigurer::disable)
            // CORS 설정 적용 //
            .cors(cors -> cors.configurationSource(configurationSource()))
            // HTTP 요청에 대한 권한 설정 //
            .authorizeHttpRequests(request->request
                // 인증없이 접근 가능한 경로 설정 //
                .requestMatchers("/api/v1/auth/**", "/oauth2/callback/*", "/file/*", "/").permitAll()
                // GET 요청에 대해 인증없이 접근 가능한 경로 설정 //
                .requestMatchers(HttpMethod.GET,
                        "/api/v1/travel/**",
                        "/api/v1/cafe/**",
                        "/api/v1/fashion/**",
                        "/api/v1/food/**",
                        "/api/v1/stay/**",
                        "/api/v1/keyword/**",
                        "/api/v1/vote/**",
                        "/api/v1/hall-of-fame/**").permitAll()
                    // POST 요청에 대해 인증없이 접근 가능한 경로 설정 //
                    .requestMatchers(HttpMethod.POST, "/api/v1/travel/view/*", "/api/v1/cafe/view/*","/api/v1/food/view/*","/api/v1/stay/view/*","/api/v1/fashion/view/*").permitAll()
                // 그 외 모든 요청은 인증 필요 //
                .anyRequest().authenticated())
            // 인증 실패 시 처리 설정 //
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(new AuthenticationFailEntryPoint()))

            // OAuth2 로그인 설정 //
            .oauth2Login(oauth2 -> oauth2
                // OAuth2 리다이렉션 엔드포인트 설정 //
                .redirectionEndpoint(endpoint -> endpoint.baseUri("/oauth2/callback/*"))
                // OAuth2 인증 엔드포인트 설정 //
                .authorizationEndpoint(endpoint -> endpoint
                    .baseUri("/api/v1/auth/sns-sign-in"))
                // OAuth2 사용자 정보 엔드포인트 설정 //    
                .userInfoEndpoint(endpoint -> endpoint.userService(oAuth2Service))
                // OAuth2 인증 성공 핸들러 설정 //
                .successHandler(oAuth2SuccessHandler))
            // JWT 인증 필터 추가 //
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        return security.build();
        }

    // CORS 설정을 위한 Bean //
    @Bean
    protected CorsConfigurationSource configurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        // 모든 출처 허용 //
        configuration.addAllowedOrigin("*");
        // 모든 헤더 허용 //
        configuration.addAllowedHeader("*");
        // 모든 HTTP 메서드 허용 //
        configuration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;

    }
}

// 인증 실패 시 처리를 위한 클래스 //
class AuthenticationFailEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        // 예외 스택 트레이스 출력 //
        authException.printStackTrace();
        // 응답 타입을 JSON으로 설정 //
        response.setContentType("application/json");
        // 인증 실패 상태 코드(401) 설정 //
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // 인증 실패 메시지를 JSON 형식으로 응답 //
        response.getWriter().write(
                "{ \"code\": \"" + ResponseCode.AUTHENTICATION_FAIL + "\", \"message\": \""
                        + ResponseMessage.AUTHENTICATION_FAIL + "\" }");
    }

}
