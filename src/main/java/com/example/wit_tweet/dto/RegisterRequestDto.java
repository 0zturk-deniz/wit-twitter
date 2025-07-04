package com.example.wit_tweet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterRequestDto(
        @NotNull
        @NotEmpty
        @NotBlank
        String email,

        @NotNull
        @NotEmpty
        @NotBlank
        String password
) {
}
