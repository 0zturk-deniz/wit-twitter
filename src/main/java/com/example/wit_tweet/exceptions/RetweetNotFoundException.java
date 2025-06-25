package com.example.wit_tweet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


public class RetweetNotFoundException extends TwitterException {
    public RetweetNotFoundException(String message) {
      super(message, HttpStatus.NOT_FOUND);
    }
}
