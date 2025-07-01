package com.example.wit_tweet.service;

import com.example.wit_tweet.dto.RegisterRequestDto;
import com.example.wit_tweet.dto.RegisterResponseDto;
import com.example.wit_tweet.entity.Role;
import com.example.wit_tweet.entity.User;
import com.example.wit_tweet.exceptions.UserAlreadyRegisteredException;
import com.example.wit_tweet.repository.RoleRepository;
import com.example.wit_tweet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final RoleRepository roleRepository;

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto){

        Optional<User> optionalUser = userRepository.findByEmail(registerRequestDto.email());

        if(optionalUser.isPresent()){
            throw new UserAlreadyRegisteredException("A user is already registered with this e-mail address.");
        }

        String encodePassword = passwordEncoder.encode(registerRequestDto.password());

        Role role = roleRepository.getRoleByAuthority("USER");

        User user = new User();
        user.setPassword(encodePassword);
        user.setEmail(registerRequestDto.email());
        user.setRoles(Set.of(role));

        user = userRepository.save(user);

        return new RegisterResponseDto(user.getEmail(), "User registered successfully.");
    }
}
