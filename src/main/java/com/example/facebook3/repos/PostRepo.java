package com.example.facebook3.repos;

import com.example.facebook3.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    @Query("SELECT p FROM Post p WHERE p.userId=:userid")
    List<Post> getPosts(@Param("userid") int userid);

    @Query("select post from Post where userId in(select followerId from Follower WHERE followeeId=:userId)")
    List<String> getFeeds(@Param("userId") int userid);
}
