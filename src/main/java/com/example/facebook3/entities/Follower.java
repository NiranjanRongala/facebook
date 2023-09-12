package com.example.facebook3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_no")
    private int sno;
    @Column(name = "followee_id")
    private int followeeid;
    @Column(name = "follower_id")
    private int followerid;
    @Column(name = "created_at")
    private LocalDateTime createdat;
    @Column(name = "updated_at")
    private LocalDateTime updatedat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id", updatable = false, insertable = false)
    @JsonIgnore
    private User users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", updatable = false, insertable = false)
    @JsonIgnore
    private User users1;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getFolloweeid() {
        return followeeid;
    }

    public void setFolloweeid(int followeeid) {
        this.followeeid = followeeid;
    }

    public int getFollowerid() {
        return followerid;
    }

    public void setFollowerid(int followerid) {
        this.followerid = followerid;
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
}
