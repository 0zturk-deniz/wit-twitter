package com.example.wit_tweet.mapper;

import com.example.wit_tweet.dto.LikeRequestDto;
import com.example.wit_tweet.entity.Like;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper {

    public Like toEntity(LikeRequestDto likeRequestDto){
        Like like = new Like();
        like.setUser(likeRequestDto.userId());
        like.setTweet(likeRequestDto.tweetId());

       return like;
    }
}