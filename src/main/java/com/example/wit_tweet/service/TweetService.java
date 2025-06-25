package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Tweet;

import java.util.List;

public interface TweetService {
    List<Tweet> getAll();
    Tweet get(Long id);
    Tweet save(Tweet tweet);
    void delete(Long id);
}
