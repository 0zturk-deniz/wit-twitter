package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.exceptions.TweetNotFoundException;
import com.example.wit_tweet.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

    @Autowired
    private final TweetRepository tweetRepository;

    @Override
    public List<Tweet> getAll() {
        return tweetRepository.findAll();
    }

    @Override
    public Tweet get(Long id) {
        return tweetRepository.findById(id).orElseThrow(()-> new TweetNotFoundException(id + "li tweet bulunamadı."));
    }

    @Override
    public Tweet save(Tweet tweet) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
