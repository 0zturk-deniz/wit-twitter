package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getAll();
    Reply get(Long id);
    Reply save(Reply reply);
    void delete(Long id);
}
