package com.example.wit_tweet.mapper;

import com.example.wit_tweet.dto.LikeRequestDto;
import com.example.wit_tweet.dto.LikeResponseDto;
import com.example.wit_tweet.entity.Like;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.service.TweetService;
import com.example.wit_tweet.service.UserService;
import org.springframework.stereotype.Component;


@Component
public class LikeMapper {

    private UserService userService;
    private TweetService tweetService;

    public Like toEntity(LikeRequestDto likeRequestDto){
        User user = userService.getEntityById(likeRequestDto.userId());
        Tweet tweet = tweetService.getEntityById(likeRequestDto.tweetId());

        Like like = new Like();
        like.setUser(user);
        like.setTweet(tweet);

        return like;
    }

    public LikeResponseDto toResponseDto(Like like){
        return new LikeResponseDto(like.getId(), like.getUserId(), like.getTweetId());
    }


}