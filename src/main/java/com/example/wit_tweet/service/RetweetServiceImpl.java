package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.RetweetRequestDto;
import com.example.wit_tweet.dto.RetweetResponseDto;
import com.example.wit_tweet.entity.Retweet;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.exceptions.AlreadyRetweetedException;
import com.example.wit_tweet.exceptions.RetweetNotFoundException;
import com.example.wit_tweet.mapper.RetweetMapper;
import com.example.wit_tweet.repository.RetweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetweetServiceImpl implements RetweetService{

    private UserService userService;
    private TweetService tweetService;

    @Autowired
    private final RetweetRepository retweetRepository;

    @Autowired
    private final RetweetMapper retweetMapper;

    @Override
    public List<Retweet> getAll() {
        return retweetRepository.findAll();
    }

    @Override
    public Retweet get(Long id) {
        return retweetRepository.findById(id).orElseThrow(()-> new RetweetNotFoundException(id + "li retweet bulunamadı."));
    }

    @Override
    public Retweet getEntityById(Long id){
        return retweetRepository
                .findById(id)
                .orElseThrow(()->new RetweetNotFoundException(id + "li retweet bulunamadı."));
    }

    @Override
    public RetweetResponseDto save(RetweetRequestDto retweetRequestDto) {

        User user = userService.getEntityById(retweetRequestDto.userId());
        Tweet tweet = tweetService.getEntityById(retweetRequestDto.tweetId());

        Optional<Retweet> existingRetweet = retweetRepository.findByUserAndTweet(user, tweet);
        if(existingRetweet.isPresent()){
            throw new AlreadyRetweetedException("Bu tweet zaten retweetlenmiş.");
        }

        Retweet retweet = retweetMapper.toEntity(retweetRequestDto);
        Retweet saved = retweetRepository.save(retweet);

        return retweetMapper.toResponseDto(saved);
    }

    @Override
    public void delete(Long id) {
        retweetRepository.deleteById(id);
    }
}
