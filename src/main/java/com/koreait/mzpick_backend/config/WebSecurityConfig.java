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

@Configurable
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OAuth2UserServiceImplement oAuth2Service;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
        security
            .httpBasic(HttpBasicConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .csrf(CsrfConfigurer::disable)
            .cors(cors -> cors.configurationSource(configurationSource()))
            .authorizeHttpRequests(request->request
                .requestMatchers("/api/v1/auth/**", "/oauth2/callback/*", "/file/*", "/").permitAll()
                .requestMatchers(HttpMethod.GET,
                        "/api/v1/travel/**",
                        "api/v1/cafe/**",
                        "api/v1/fashion/**",
                        "/api/v1/food/**",
                        "api/v1/stay/**",
                        "api/v1/keyword/**",
                        "api/v1/vote/**",
                        "api/v1/hall-of-fame/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/v1/travel/view/*", "/api/v1/cafe/view/*","api/v1/food/view/*","api/v1/stay/view/*","/api/v1/fashion/view/*").permitAll()
                .anyRequest().authenticated())
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(new AuthenticationFailEntryPoint()))
                
            .oauth2Login(oauth2 -> oauth2
                .redirectionEndpoint(endpoint -> endpoint.baseUri("oauth2/callback/*"))
                .authorizationEndpoint(endpoint -> endpoint
                    .baseUri("/api/v1/auth/sns-sign-in"))
                .userInfoEndpoint(endpoint -> endpoint.userService(oAuth2Service))
                .successHandler(oAuth2SuccessHandler))
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        return security.build();
        }

    @Bean
    protected CorsConfigurationSource configurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;

    }
}

class AuthenticationFailEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(
                "{ \"code\": \"" + ResponseCode.AUTHENTICATION_FAIL + "\", \"message\": \""
                        + ResponseMessage.AUTHENTICATION_FAIL + "\" }");
    }

}
