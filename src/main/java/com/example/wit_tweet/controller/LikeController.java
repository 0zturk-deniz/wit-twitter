package com.example.wit_tweet.controller;

import com.example.wit_tweet.dto.LikeRequestDto;
import com.example.wit_tweet.entity.Like;
import com.example.wit_tweet.service.LikeService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    @Autowired
    private final LikeService likeService;

    @GetMapping
    public List<Like> getAll(){
        return likeService.getAll();
    }

    @GetMapping("/{id}")
    public Like getById(@Positive @PathVariable("id") Long id){
        return likeService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Like save(@Validated @RequestBody LikeRequestDto like) {
        return likeService.save(like);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        likeService.delete(id);
    }
}
