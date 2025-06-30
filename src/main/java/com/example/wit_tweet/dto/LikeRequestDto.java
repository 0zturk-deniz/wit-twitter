package com.example.wit_tweet.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public record LikeRequestDto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,

        Long userId,

        Long tweetId
) {
}
