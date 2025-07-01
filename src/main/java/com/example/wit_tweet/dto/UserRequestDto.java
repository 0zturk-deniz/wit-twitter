package com.example.wit_tweet.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

public record UserRequestDto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,

        @Size(max = 20) String userName,

        String photoUrl
) {
}
