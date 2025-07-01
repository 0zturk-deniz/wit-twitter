package com.example.wit_tweet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "liked_tweets")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Column(name = "tweet_id", insertable = false, updatable = false)
    private Long tweetId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @Override
    public boolean equals(Object object) {
        if(object == this)
            return true;
        if(object == null || object.getClass() != getClass())
            return false;
        Like like = (Like) object;
        return like.getId().equals(getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
