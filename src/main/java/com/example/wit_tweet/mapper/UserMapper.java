package com.example.wit_tweet.mapper;

import com.example.wit_tweet.dto.UserRequestDto;
import com.example.wit_tweet.dto.UserResponseDto;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private UserService userService;

    public User toEntity(UserRequestDto userRequestDto){
        User user = new User();
        user.setId(userRequestDto.id());
        user.setUserName(userRequestDto.userName());
        user.setPhotoUrl(userRequestDto.photoUrl());

        return user;
    }

    public UserResponseDto toResponseDto(User user){
        return new UserResponseDto(user.getId(), user.getUsername(), user.getPhotoUrl());
    }
}
