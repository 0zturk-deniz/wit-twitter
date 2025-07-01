package com.example.wit_tweet.exceptions;

import org.springframework.http.HttpStatus;

public class RetweetNotFoundException extends TwitterException {
    public RetweetNotFoundException(String message) {
      super(message, HttpStatus.NOT_FOUND);
    }
}
