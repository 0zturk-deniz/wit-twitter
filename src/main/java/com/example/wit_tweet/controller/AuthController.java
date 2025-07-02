package com.example.wit_tweet.controller;

import com.example.wit_tweet.dto.RegisterRequestDto;
import com.example.wit_tweet.dto.RegisterResponseDto;
import com.example.wit_tweet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponseDto register(@Validated @RequestBody RegisterRequestDto registerRequestDto){
        return authService.register(registerRequestDto);
    }
}
