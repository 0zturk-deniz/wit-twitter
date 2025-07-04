package com.example.wit_tweet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "reply_tweets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reply_time")
    private OffsetDateTime replyTime;

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
        Reply reply = (Reply) object;
        return reply.getId().equals(getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
