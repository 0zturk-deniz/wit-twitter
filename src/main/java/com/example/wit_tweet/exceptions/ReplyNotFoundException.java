package com.example.wit_tweet.exceptions;

import org.springframework.http.HttpStatus;

public class ReplyNotFoundException extends TwitterException {

    public ReplyNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
