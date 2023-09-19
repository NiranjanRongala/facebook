package com.example.facebook3.repos;

import com.example.facebook3.entities.Follower;
import com.example.facebook3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {


    Optional<User> findByUserName(String username);
//
//@Query("select r.roleName from Role r where r.roleId=(select u.role from User u where u.username=:username )")
//String getRoleName(@Param("username")String username);


//
//    @Query("select u.role from User u where u.username=:username ")
//    String getRoleName(@Param("username")String username);

}
