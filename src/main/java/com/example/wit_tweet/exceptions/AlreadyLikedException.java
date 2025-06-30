package com.example.wit_tweet.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyLikedException extends TwitterException {
    public AlreadyLikedException(String message) {

        super(message, HttpStatus.NOT_FOUND);
    }
}
