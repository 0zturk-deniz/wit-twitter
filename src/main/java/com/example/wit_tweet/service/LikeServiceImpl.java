package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.Like;
import com.example.wit_tweet.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{

    @Autowired
    private final LikeRepository likeRepository;

    @Override
    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    @Override
    public Like get(Long id) {
        return likeRepository.findById(id).orElseThrow(()-> new LikeNotFoundException());
    }

    @Override
    public Like save(Like like) {
        Optional<Like> optionalLike = likeRepository.findById(like.getId());

        if(optionalLike.isPresent()){
            like.setId(like.getId());
        }
        return likeRepository.save(like);
    }

    @Override
    public Like update(Long id, Like like) {
        return update(like);
    }

    @Override
    public void delete(Long id) {

    }
}
