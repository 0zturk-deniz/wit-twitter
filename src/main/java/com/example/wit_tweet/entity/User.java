package com.example.wit_tweet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    @Size(max = 20)
    private String userName;

    @Column(name = "photo_url")
    private String photoUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Tweet> tweets;
    private Set<Like> likes;
    private Set<Reply> replies;
    private Set<Retweet> retweets;

    public void addTweet(Tweet tweet){

        if(tweet == null)
            throw new IllegalArgumentException("Tweet can not be null");

        if(tweet.getUser().equals(this))
            tweets.add(tweet);

    }

    @Override
    public boolean equals(Object object) {
        if(object == this)
            return true;
        if(object == null || object.getClass() != getClass())
            return false;
        User user = (User) object;
        return user.getId().equals(getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
