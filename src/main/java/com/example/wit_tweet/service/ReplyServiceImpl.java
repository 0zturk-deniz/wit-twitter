package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.ReplyRequestDto;
import com.example.wit_tweet.dto.ReplyResponseDto;
import com.example.wit_tweet.entity.Reply;
import com.example.wit_tweet.exceptions.ReplyNotFoundException;
import com.example.wit_tweet.mapper.ReplyMapper;
import com.example.wit_tweet.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private final ReplyRepository replyRepository;

    private UserService userService;
    private final ReplyMapper replyMapper;


    @Override
    public List<ReplyResponseDto> getAll() {

        return replyRepository
                .findAll()
                .stream()
                .map(replyMapper::toResponseDto)
                .toList();
    }

    @Override
    public ReplyResponseDto get(Long id) {
        return replyRepository
                .findById(id)
                .map(replyMapper::toResponseDto)
                .orElseThrow(()->new ReplyNotFoundException(id + "li tweet bulunamadı."));
    }

    @Override
    public ReplyResponseDto save(ReplyRequestDto replyRequestDto) {

        Reply reply = replyMapper.toEntity(replyRequestDto);
        Reply saved = replyRepository.save(reply);

        return replyMapper.toResponseDto(saved);
    }

    @Override
    public void delete(Long id) {
        replyRepository.deleteById(id);
    }
}
