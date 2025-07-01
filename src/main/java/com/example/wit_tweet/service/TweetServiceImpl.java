package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.TweetRequestDto;
import com.example.wit_tweet.dto.TweetResponseDto;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.exceptions.TweetNotFoundException;
import com.example.wit_tweet.mapper.TweetMapper;
import com.example.wit_tweet.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {


    private UserService userService;
    private TweetMapper tweetMapper;

    @Autowired
    private final TweetRepository tweetRepository;

    @Override
    public List<TweetResponseDto> getAll() {

        return tweetRepository
                .findAll()
                .stream()
                .map(tweetMapper::toResponseDto)
                .toList();
    }

    @Override
    public TweetResponseDto get(Long id) {
        return tweetRepository
                .findById(id)
                .map(tweetMapper::toResponseDto)
                .orElseThrow(()-> new TweetNotFoundException(id + "li tweet bulunamadı."));
    }

    @Override
    public Tweet getEntityById(Long id){
        return tweetRepository
                .findById(id)
                .orElseThrow(()->new TweetNotFoundException(id + "li tweet bulunamadı."));
    }

    @Override
    public TweetResponseDto save(TweetRequestDto tweetRequestDto) {

        Tweet tweet = tweetMapper.toEntity(tweetRequestDto);
        tweet.setCreatedAt(OffsetDateTime.now());

        Tweet saved = tweetRepository.save(tweet);

        return tweetMapper.toResponseDto(saved);

    }

    @Override
    public void delete(Long id) {
        tweetRepository.deleteById(id);

    }
}
