package com.example.facebook3.repos;

import com.example.facebook3.entities.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowerRepo extends JpaRepository<Follower, Integer> {

    @Query("DELETE FROM Follower f WHERE f.followeeid = :followee_id")
    void deleteFollower(@Param("followee_id") int user_id);

    @Query("SELECT f FROM Follower f WHERE f.followeeid = :followee_id")
    List<Follower> getFollowers(@Param("followee_id") int userid);
}
