package com.koreait.mzpick_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.auth.IdCheckRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.SignInRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.SignUpRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.TelAuthCheckRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.TelAuthRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.auth.SignInResponseDto;
import com.koreait.mzpick_backend.service.auth.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<ResponseDto> idCheck(
        @RequestBody @Valid IdCheckRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = authService.idCheck(requestBody);
        return response;
    }
    
    @PostMapping("/tel-auth")
    public ResponseEntity<ResponseDto> telAuth(
        @RequestBody @Valid TelAuthRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = authService.telAuth(requestBody);
        return response;
    }

    @PostMapping("/tel-auth-check")
    public ResponseEntity<ResponseDto> telAuthCheck(
        @RequestBody @Valid TelAuthCheckRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = authService.telAuthCheck(requestBody);
        return response;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestbody
    ){
        ResponseEntity<ResponseDto> response = authService.signUp(requestbody);
        return response;
    }
    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signin(
        @RequestBody @Valid SignInRequestDto requestBody
    ){
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }
}
