package com.example.wit_tweet.mapper;

import com.example.wit_tweet.dto.ReplyRequestDto;
import com.example.wit_tweet.dto.ReplyResponseDto;
import com.example.wit_tweet.entity.Reply;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.service.TweetService;
import com.example.wit_tweet.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    private UserService userService;
    private TweetService tweetService;

    public Reply toEntity(ReplyRequestDto replyRequestDto){
        User user = userService.getEntityById(replyRequestDto.userId());
        Tweet tweet = tweetService.getEntityById(replyRequestDto.tweetId());

        Reply reply = new Reply();
        reply.setUser(user);
        reply.setTweet(tweet);

        return reply;
    }

    public ReplyResponseDto toResponseDto(Reply reply){
        return new ReplyResponseDto((reply.getId()), reply.getUser().getId(), reply.getTweet().getId(), reply.getReplyTime());
    }



}
