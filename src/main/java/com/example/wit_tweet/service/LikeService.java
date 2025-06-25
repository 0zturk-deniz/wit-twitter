package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Like;

import java.util.List;

public interface LikeService {
    List<Like> getAll();
    Like get(Long id);
    Like save(Like like);
    Like update(Long id, Like like);
    void delete(Long id);
}
