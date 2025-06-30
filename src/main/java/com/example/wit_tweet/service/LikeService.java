package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.LikeRequestDto;
import com.example.wit_tweet.dto.LikeResponseDto;
import com.example.wit_tweet.entity.Like;

import java.util.List;

public interface LikeService {
    List<LikeResponseDto> getAll();
    LikeResponseDto get(Long id);
    LikeResponseDto save(LikeRequestDto likeRequestDto);
    void delete(Long id);
}
