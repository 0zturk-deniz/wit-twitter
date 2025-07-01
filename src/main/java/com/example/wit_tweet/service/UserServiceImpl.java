package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.UserRequestDto;
import com.example.wit_tweet.dto.UserResponseDto;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.exceptions.UserNotFoundException;
import com.example.wit_tweet.mapper.UserMapper;
import com.example.wit_tweet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAll() {

        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto get(Long id) {
        return userRepository
                .findById(id)
                .map(userMapper::toResponseDto)
                .orElseThrow(()-> new UserNotFoundException(id + "li user bulunamadı."));
    }

    @Override
    public User getEntityById(Long id){
        return userRepository
                .findById(id)
                .orElseThrow(()-> new UserNotFoundException(id + "li user bulunamadı."));
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id + "li user bulunamadı."));

        if (userRequestDto.userName() != null) {
            existingUser.setUserName(userRequestDto.userName());
        }

        if (userRequestDto.photoUrl() != null) {
            existingUser.setPhotoUrl(userRequestDto.photoUrl());
        }

        User updatedUser = userRepository.save(existingUser);

        return userMapper.toResponseDto(updatedUser);
    }


    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {

        User user = userMapper.toEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);

    }



    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
