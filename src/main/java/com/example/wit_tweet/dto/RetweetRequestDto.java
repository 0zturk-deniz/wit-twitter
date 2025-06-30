package com.example.wit_tweet.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

public record RetweetRequestDto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,

        Long userId,
        Long tweetId,
        OffsetDateTime retweetTime
) {
}
