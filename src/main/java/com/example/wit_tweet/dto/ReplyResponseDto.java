package com.example.wit_tweet.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

public record ReplyResponseDto(
        Long id,

        Long userId,

        Long tweetId,

        OffsetDateTime replyTime
) {
}
