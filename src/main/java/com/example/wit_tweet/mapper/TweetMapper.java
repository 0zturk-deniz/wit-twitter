package com.example.wit_tweet.mapper;

import com.example.wit_tweet.dto.TweetRequestDto;
import com.example.wit_tweet.dto.TweetResponseDto;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.service.TweetService;
import com.example.wit_tweet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {

    @Autowired
    private UserService userService;

    private TweetService tweetService;

    public Tweet toEntity(TweetRequestDto tweetRequestDto){
        User user = userService.getEntityById(tweetRequestDto.userId());

        Tweet tweet = new Tweet();
        tweet.setContent(tweetRequestDto.content());
        tweet.setUser(user);
        tweet.setCreatedAt(tweetRequestDto.createdAt());

        return tweet;
    }

    public TweetResponseDto toResponseDto(Tweet tweet){
        return new TweetResponseDto(tweet.getId(), tweet.getUser().getId(), tweet.getContent(), tweet.getCreatedAt());
    }
}
