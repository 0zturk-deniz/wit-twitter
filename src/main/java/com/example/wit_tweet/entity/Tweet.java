package com.example.wit_tweet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tweet")
@Getter
@Setter
@ToString
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    @Size(max = 140)
    private String content;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object object) {
        if(object == this)
            return true;
        if(object == null || object.getClass() != getClass())
            return false;
        Tweet tweet = (Tweet) object;
        return tweet.getId().equals(getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
