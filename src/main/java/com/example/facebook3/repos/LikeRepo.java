package com.example.facebook3.repos;

import com.example.facebook3.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepo extends JpaRepository<Like, Integer> {
    @Query("SELECT l FROM Like l WHERE postid=:postid ")
    List<Like> getLikes(@Param("postid") int postId);

}
