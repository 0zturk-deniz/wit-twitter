package com.example.wit_tweet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "retweet")
public class Retweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "retweet_time")
    private OffsetDateTime retweetTime;

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
        Retweet retweet = (Retweet) object;
        return retweet.getId().equals(getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
