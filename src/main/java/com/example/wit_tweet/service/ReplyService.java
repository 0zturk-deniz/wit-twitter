package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.ReplyRequestDto;
import com.example.wit_tweet.dto.ReplyResponseDto;
import com.example.wit_tweet.entity.Reply;

import java.util.List;

public interface ReplyService {
    List<ReplyResponseDto> getAll();
    ReplyResponseDto get(Long id);
    ReplyResponseDto save(ReplyRequestDto replyRequestDto);
    void delete(Long id);

    Reply getEntityById(Long id);
}
