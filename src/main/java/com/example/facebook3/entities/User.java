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
    @Column(name = "user_id")
    private int userid;
    @Column(name = "username")
    private String username;
    @Column(name = "phone_number")
    private String phonenumber;
    @Column(name = "created_at")
    private LocalDateTime createdat;
    @Column(name = "updated_at")
    private LocalDateTime updatedat;


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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
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
