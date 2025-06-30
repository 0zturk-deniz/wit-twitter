package com.example.wit_tweet.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public record LikeResponseDto(
      Long id,

      Long userId,

      Long tweetId
) {
}
