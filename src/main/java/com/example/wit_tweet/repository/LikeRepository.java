package com.example.wit_tweet.repository;

import com.example.wit_tweet.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
