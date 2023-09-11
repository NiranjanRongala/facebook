package com.example.facebook3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_no;
    private int followee_id;
    private int follower_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id", updatable = false, insertable = false)
    @JsonIgnore
    private User users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", updatable = false, insertable = false)
    @JsonIgnore
    private User users1;

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public int getFollowee_id() {
        return followee_id;
    }

    public void setFollowee_id(int followee_id) {
        this.followee_id = followee_id;
    }

    public int getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(int follower_id) {
        this.follower_id = follower_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public User getUsers1() {
        return users1;
    }

    public void setUsers1(User users1) {
        this.users1 = users1;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
