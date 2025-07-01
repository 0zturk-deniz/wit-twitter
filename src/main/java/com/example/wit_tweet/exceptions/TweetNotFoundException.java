package com.example.wit_tweet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


public class TweetNotFoundException extends TwitterException {
    public TweetNotFoundException(String message) {

        super(message, HttpStatus.NOT_FOUND);
    }
}
