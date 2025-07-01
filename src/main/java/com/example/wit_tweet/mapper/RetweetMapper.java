package com.example.wit_tweet.mapper;

import com.example.wit_tweet.dto.RetweetRequestDto;
import com.example.wit_tweet.dto.RetweetResponseDto;
import com.example.wit_tweet.entity.Retweet;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.service.TweetService;
import com.example.wit_tweet.service.UserService;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class RetweetMapper {

    private UserService userService;
    private TweetService tweetService;

    public Retweet toEntity(RetweetRequestDto retweetRequestDto){
        User user = userService.getEntityById(retweetRequestDto.userId());
        Tweet tweet = tweetService.getEntityById(retweetRequestDto.tweetId());


        Retweet retweet = new Retweet();
        retweet.setUser(user);
        retweet.setTweet(tweet);
        retweet.setRetweetTime(OffsetDateTime.now());

        return retweet;
    }

    public RetweetResponseDto toResponseDto(Retweet retweet){
        return new RetweetResponseDto(retweet.getId(), retweet.getUserId(), retweet.getTweetId(), retweet.getRetweetTime());
    }

}
