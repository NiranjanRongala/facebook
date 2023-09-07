package com.example.facebook3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String phone_number;
    private LocalDateTime created_at;


    
    @OneToMany(mappedBy = "users")
    @JsonIgnore // ignore the property from serialization
    private List<Follower> followers = new ArrayList<Follower>();

    @OneToMany(mappedBy = "users1")
    @JsonIgnore // ignore the property from serialization
    private List<Follower> followers1 = new ArrayList<Follower>();

    @OneToMany(mappedBy = "users")
    @JsonIgnore // ignore the property from serialization
    private List<Post> posts = new ArrayList<Post>();


    @OneToMany(mappedBy = "users")
    @JsonIgnore // ignore the property from serialization
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "users")
    @JsonIgnore // ignore the property from serialization
    private List<Like> likes = new ArrayList<Like>();

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<Follower> getFollowers1() {
        return followers1;
    }

    public void setFollowers1(List<Follower> followers1) {
        this.followers1 = followers1;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}
