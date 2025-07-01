package com.example.wit_tweet.controller;

import com.example.wit_tweet.dto.UserRequestDto;
import com.example.wit_tweet.dto.UserResponseDto;
import com.example.wit_tweet.service.UserService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@Positive @PathVariable("id") Long id){
        return userService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto save(@Validated @RequestBody UserRequestDto user){
        return userService.save(user);
    }

    @PatchMapping("/{id}")
    public UserResponseDto update(@Positive @PathVariable("id") Long id,
                       @Validated @RequestBody UserRequestDto userRequestDto){
        return userService.update(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        userService.delete(id);
    }
}
