package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Reply;
import com.example.wit_tweet.exceptions.ReplyNotFoundException;
import com.example.wit_tweet.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private final ReplyRepository replyRepository;

    @Override
    public List<Reply> getAll() {
        return replyRepository.findAll();
    }

    @Override
    public Reply get(Long id) {
        return replyRepository.findById(id).orElseThrow(()->new ReplyNotFoundException(id + "li tweet bulunamadı."));
    }

    @Override
    public Reply save(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public void delete(Long id) {
        replyRepository.deleteById(id);
    }
}
