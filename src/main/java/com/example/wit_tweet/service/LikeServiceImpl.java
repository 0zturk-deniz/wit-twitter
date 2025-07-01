package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.LikeRequestDto;
import com.example.wit_tweet.dto.LikeResponseDto;
import com.example.wit_tweet.entity.Like;
import com.example.wit_tweet.entity.Tweet;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.exceptions.AlreadyLikedException;
import com.example.wit_tweet.exceptions.LikeNotFoundException;
import com.example.wit_tweet.mapper.LikeMapper;
import com.example.wit_tweet.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{

    private UserService userService;
    private TweetService tweetService;

    @Autowired
    private final LikeRepository likeRepository;

    @Autowired
    private final LikeMapper likeMapper;

    @Override
    public List<LikeResponseDto> getAll() {
        return likeRepository
                .findAll()
                .stream()
                .map(likeMapper::toResponseDto)
                .toList();
    }

    @Override
    public LikeResponseDto get(Long id) {

        Optional<Like> optionalLike = likeRepository
                .findById(id);

        if(optionalLike.isPresent()){
            return likeMapper.toResponseDto(optionalLike.get());
        }
        throw new LikeNotFoundException(id + "li like bulunamadı.");
    }

    @Override
    public Like getEntityById(Long id){
        return likeRepository
                .findById(id)
                .orElseThrow(()-> new LikeNotFoundException(id + "li like bulunamadı."));
    }

    @Override
    public LikeResponseDto save(LikeRequestDto likeDto) {

        User user = userService.getEntityById(likeDto.userId());
        Tweet tweet = tweetService.getEntityById(likeDto.tweetId());

        Optional<Like> existingLike = likeRepository.findByUserAndTweet(user, tweet);
        if (existingLike.isPresent()) {
            throw new AlreadyLikedException("Bu tweet zaten beğenilmiş.");
        }

        Like like = likeMapper.toEntity(likeDto);
        Like saved = likeRepository.save(like);

        return likeMapper.toResponseDto(saved);
    }

    @Override
    public void delete(Long id) {
        likeRepository.deleteById(id);
    }
}
