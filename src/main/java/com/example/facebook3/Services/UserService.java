//package com.example.facebook3.Services;
//
//import com.example.facebook3.entities.User;
//import com.example.facebook3.exceptions.InvalidNameFormatException;
//import org.springframework.data.domain.Page;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//public interface UserService {
//    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
//
//    User addUser(User users) throws InvalidNameFormatException;
//
//    void removeUser(int user_id) throws InvalidNameFormatException;
//
//    User updateUserName(int user_id, String user_name) throws InvalidNameFormatException;
//
//    List<User> getUsers() throws InvalidNameFormatException;
//
//    Page<User> getUserPage(int offset, int limit);
//
//    Page<User> getUserPageBySort(int offset, int limit, String sortby);
//
//    User updateUserPassword(int user_id, String password) throws InvalidNameFormatException;
//
//    User updateRole(int user_id, String role) throws InvalidNameFormatException;
//
//
//}
