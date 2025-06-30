package com.example.wit_tweet.controller;

import com.example.wit_tweet.dto.ReplyRequestDto;
import com.example.wit_tweet.dto.ReplyResponseDto;
import com.example.wit_tweet.service.ReplyService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    @Autowired
    private final ReplyService replyService;

    @GetMapping
    public List<ReplyResponseDto> getAll(){
        return replyService.getAll();
    }

    @GetMapping("/{id}")
    public ReplyResponseDto getById(@Positive @PathVariable("id") Long id){
        return replyService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReplyResponseDto save(@Validated @RequestBody ReplyRequestDto replyRequestDto){
        return replyService.save(replyRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        replyService.delete(id);
    }
}
