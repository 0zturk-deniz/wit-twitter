package com.example.wit_tweet.repository;

import com.example.wit_tweet.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
