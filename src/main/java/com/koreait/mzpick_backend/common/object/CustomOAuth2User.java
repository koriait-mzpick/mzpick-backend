package com.koreait.mzpick_backend.common.object;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;

// OAuth2User 인터페이스를 구현한 커스텀 사용자 클래스 //
public class CustomOAuth2User implements OAuth2User{

    // 사용자 이름 //
    private String name;
    // OAuth2 인증 속성 정보 //
    private Map<String, Object> attributes;
    // 사용자 권한 정보 //
    private Collection<? extends GrantedAuthority> authorities;
    // 기존 사용자 여부 //
    private boolean existed;

    // CustomOAuth2User 생성자 //
    public CustomOAuth2User(String name ,Map<String, Object> attributes, boolean existed){
        this.name = name;
        this.attributes = attributes;
        this.authorities = AuthorityUtils.NO_AUTHORITIES;
        this.existed = existed;
    }
    
    // OAuth2 인증 속성 정보 반환 메서드 //
    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    // 사용자 권한 정보 반환 메서드 //
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    // 사용자 이름 반환 메서드 //
    @Override
    public String getName() {
        return this.name;
    }

    // 기존 사용자 여부 반환 메서드 //
    public boolean isExisted(){
        return this.existed;
    }
}

