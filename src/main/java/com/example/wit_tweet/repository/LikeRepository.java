package com.example.wit_tweet.repository;

import com.example.wit_tweet.entity.Like;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndTweet(User user, Tweet tweet);
}
