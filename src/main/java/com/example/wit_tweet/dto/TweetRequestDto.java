package com.example.wit_tweet.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

public record TweetRequestDto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        Long userId,

        @Size(max = 140) String content,

        OffsetDateTime createdAt
) {
}
