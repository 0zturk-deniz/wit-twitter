package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Retweet;

import java.util.List;

public interface RetweetService {
    List<Retweet> getAll();
    Retweet get(Long id);
    Retweet save(Retweet retweet);
    void delete(Long id);
}
