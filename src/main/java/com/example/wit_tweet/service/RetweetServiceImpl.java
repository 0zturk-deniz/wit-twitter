package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Retweet;
import com.example.wit_tweet.exceptions.RetweetNotFoundException;
import com.example.wit_tweet.repository.RetweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetweetServiceImpl implements RetweetService{

    @Autowired
    private final RetweetRepository retweetRepository;

    @Override
    public List<Retweet> getAll() {
        return retweetRepository.findAll();
    }

    @Override
    public Retweet get(Long id) {
        return retweetRepository.findById(id).orElseThrow(()-> new RetweetNotFoundException(id + "li retweet bulunamadı."));
    }

    @Override
    public Retweet save(Retweet retweet) {
        return retweetRepository.save(retweet);
    }

    @Override
    public void delete(Long id) {
        retweetRepository.deleteById(id);
    }
}
