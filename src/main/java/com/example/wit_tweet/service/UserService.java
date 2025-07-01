package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.UserRequestDto;
import com.example.wit_tweet.dto.UserResponseDto;
import com.example.wit_tweet.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAll();
    UserResponseDto get(Long id);
    UserResponseDto save(UserRequestDto userRequestDto);
    UserResponseDto update(Long id, UserRequestDto userRequestDto);
    void delete(Long id);

    User getEntityById(Long id);
}
