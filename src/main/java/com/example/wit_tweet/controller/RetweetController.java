package com.example.wit_tweet.controller;

import com.example.wit_tweet.dto.RetweetRequestDto;
import com.example.wit_tweet.dto.RetweetResponseDto;
import com.example.wit_tweet.entity.Retweet;
import com.example.wit_tweet.service.RetweetService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retweets")
@RequiredArgsConstructor
public class RetweetController {

    @Autowired
    private final RetweetService retweetService;

    @GetMapping
    public List<Retweet> getAll(){
        return retweetService.getAll();
    }

    @GetMapping("/{id}")
    public Retweet getById(@Positive @PathVariable("id") Long id){
        return retweetService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetweetResponseDto save(@Validated @RequestBody RetweetRequestDto retweetRequestDto){
        return retweetService.save(retweetRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        retweetService.delete(id);
    }
}
