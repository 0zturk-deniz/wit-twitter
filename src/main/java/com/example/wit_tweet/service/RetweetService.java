package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.RetweetRequestDto;
import com.example.wit_tweet.dto.RetweetResponseDto;
import com.example.wit_tweet.entity.Retweet;

import java.util.List;

public interface RetweetService {
    List<Retweet> getAll();
    Retweet get(Long id);
    RetweetResponseDto save(RetweetRequestDto retweetRequestDto);
    void delete(Long id);

    Retweet getEntityById(Long id);
}
