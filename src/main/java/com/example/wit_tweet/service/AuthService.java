package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.RegisterRequestDto;
import com.example.wit_tweet.dto.RegisterResponseDto;

public interface AuthService {
    RegisterResponseDto register(RegisterRequestDto registerRequestDto);
}
