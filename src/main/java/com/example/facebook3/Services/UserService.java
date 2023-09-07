package com.example.facebook3.Services;

import com.example.facebook3.entities.User;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User addUser(User users) throws InvalidNameFormatException;

    void removeUser(int user_id) throws InvalidNameFormatException;

    User updateUserName(int user_id, String user_name) throws InvalidNameFormatException;

    List<User> getUsers() throws InvalidNameFormatException;

    Page<User> getuserPage(int offset, int limit);

    Page<User> getuserPagebySort(int offset, int limit, String sortby);


}
