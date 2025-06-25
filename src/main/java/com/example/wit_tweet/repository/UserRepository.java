package com.example.wit_tweet.repository;

import com.example.wit_tweet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
