package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.TweetRequestDto;
import com.example.wit_tweet.dto.TweetResponseDto;
import com.example.wit_tweet.entity.Tweet;

import java.util.List;

public interface TweetService {
    List<TweetResponseDto> getAll();
    TweetResponseDto get(Long id);
    TweetResponseDto save(TweetRequestDto tweet);
    void delete(Long id);

    Tweet getEntityById(Long id);
}
