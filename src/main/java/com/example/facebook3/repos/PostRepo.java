package com.example.facebook3.repos;

import com.example.facebook3.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    @Query("SELECT p FROM Post p WHERE p.user_id=:userid")
    List<Post> getPosts(@Param("userid") int userid);

    @Query("select post from Post where user_id in(select follower_id from Follower WHERE followee_id=:userId)")
    List<String> getfeeds(@Param("userId") int userid);
}
