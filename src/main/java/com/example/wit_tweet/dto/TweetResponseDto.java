package com.example.wit_tweet.dto;



import java.time.OffsetDateTime;

public record TweetResponseDto(
        Long id,

        Long userId,

        String content,

        OffsetDateTime createdAt
) {
}
