package com.example.wit_tweet.service;

import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.exceptions.UserNotFoundException;
import com.example.wit_tweet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            user.setId(id);
        }
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id + "li user bulunamadı."));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
