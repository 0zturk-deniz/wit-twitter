package com.example.wit_tweet.repository;

import com.example.wit_tweet.entity.Retweet;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RetweetRepository extends JpaRepository<Retweet, Long> {

    Optional<Retweet> findByUserAndTweet(User user, Tweet tweet);
}
