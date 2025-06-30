package com.example.wit_tweet.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyRetweetedException extends TwitterException {
    public AlreadyRetweetedException(String message) {

        super(message, HttpStatus.NOT_FOUND);
    }
}
