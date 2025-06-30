package com.example.wit_tweet.controller;

import com.example.wit_tweet.dto.TweetRequestDto;
import com.example.wit_tweet.dto.TweetResponseDto;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.service.TweetService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetController {

    @Autowired
    private final TweetService tweetService;

    @GetMapping
    public List<TweetResponseDto> getAll(){
        return tweetService.getAll();
    }

    @GetMapping("/{id}")
    public TweetResponseDto getById(@Positive @PathVariable("id") Long id){
        return tweetService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponseDto save(@Validated @RequestBody TweetRequestDto tweet){
        return tweetService.save(tweet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        tweetService.delete(id);
    }


}
