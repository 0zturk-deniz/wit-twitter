package com.example.wit_tweet.controller;

import com.example.wit_tweet.dto.RegisterRequestDto;
import com.example.wit_tweet.dto.RegisterResponseDto;
import com.example.wit_tweet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    public RegisterResponseDto register(@Validated @RequestBody RegisterRequestDto registerRequestDto){
        return authService.register(registerRequestDto);
    }
}
