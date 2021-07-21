package com.hanghae99.wanted.config;

import com.hanghae99.wanted.jwt.JwtAccessDeniedHandler;
import com.hanghae99.wanted.jwt.JwtAuthenticationEntryPoint;
import com.hanghae99.wanted.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
//    private final CORSConfig corsConfig;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // CSRF 설정 Disable
//        http.csrf().disable()
//                // token을 사용하는 방식이기 때문에 csrf를 disable합니다.
//                .addFilter(corsConfig.corsFilter());

//        http.exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .accessDeniedHandler(jwtAccessDeniedHandler);

//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        // 토큰이 없는 상태에서 들어오니까 지금은 가정하고 permitAll 설정 -> 나중에 없는 부분만 따로
        http
                .authorizeRequests()
//                .antMatchers("/api/**").permitAll()
                .anyRequest().permitAll();   // 나머지 API 는 전부 인증 필요

        //하위 user까지
    }
}