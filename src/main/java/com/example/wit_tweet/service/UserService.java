package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User get(Long id);
    User save(User user);
    User update(Long id, User user);
    void delete(Long id);
}
