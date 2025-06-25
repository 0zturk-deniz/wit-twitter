package com.example.wit_tweet.repository;

import com.example.wit_tweet.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
