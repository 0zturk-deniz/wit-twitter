package com.example.wit_tweet.repository;

import com.example.wit_tweet.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetweetRepository extends JpaRepository<Retweet, Long> {

}
