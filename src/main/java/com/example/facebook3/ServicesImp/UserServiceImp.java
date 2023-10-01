package com.example.facebook3.ServicesImp;


import com.example.facebook3.entities.User;
import com.example.facebook3.entities.UsersDetails;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import com.example.facebook3.repos.FollowerRepo;
import com.example.facebook3.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImp implements UserDetailsService {

    @Autowired
    private UserRepo usersRepo;
    @Autowired
    private FollowerRepo followersRepo;
    @Autowired
    private PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> person = usersRepo.findByUserName(username);
        return person.map(UsersDetails::new).orElseThrow(() -> new RuntimeException("Invalid username"));
    }

    Pattern pattern2 = Pattern.compile("[6-9][0-9]{9}");
    Pattern pattern = Pattern.compile("[A-Z][a-z]*");


    public User addUser(User users) throws InvalidNameFormatException {
        Matcher matcher = pattern.matcher(users.getUserName());

        Matcher matcher1 = pattern2.matcher(users.getPhoneNumber());
        User users1 = new User();
        if (matcher.matches()) {
            users1.setUserName(users.getUserName());

        } else
            throw new InvalidNameFormatException("Invalid name format");
        if (matcher1.matches())
            users1.setPhoneNumber(users.getPhoneNumber());
        else
            throw new InvalidNameFormatException("invalid number");
        users1.setCreatedAt(users.getCreatedAt());
        users1.setUpdatedAt(users.getUpdatedAt());
        users1.setPassword(encoder.encode(users.getPassword()));
        users1.setRole(users.getRole());

        return usersRepo.save(users1);
    }


    public void removeUser(int user_id) throws InvalidNameFormatException {
        Optional<User> v = usersRepo.findById(user_id);
        if (v.isEmpty())
            throw new InvalidNameFormatException("user is not found");

        usersRepo.deleteById(user_id);


    }


    public User updateUserName(int user_id, String user_name) throws InvalidNameFormatException {
        Optional<User> v = usersRepo.findById(user_id);
        if (v.isEmpty())
            throw new InvalidNameFormatException("userid is not found");
        User users = v.get();
        users.setUserName(user_name);
        return usersRepo.save(users);

    }


    public List<User> getUsers() throws InvalidNameFormatException {
        List<User> users = usersRepo.findAll();

        if (users.isEmpty())
            throw new InvalidNameFormatException("there is no data in Users table");

        return usersRepo.findAll();
    }


    public Page<User> getUserPage(int offset, int limit) {

        return usersRepo.findAll(PageRequest.of(offset, limit));

    }

    public Page<User> getUserPageBySort(int offset, int limit, String sortby) {
        return usersRepo.findAll(PageRequest.of(offset, limit, Sort.by(sortby).descending()));
    }


    public User updateUserPassword(int user_id, String password) throws InvalidNameFormatException {
        Optional<User> v = usersRepo.findById(user_id);
        if (v.isEmpty())
            throw new InvalidNameFormatException("userid is not found");
        User users = v.get();
        users.setPassword(encoder.encode(password));
        return usersRepo.save(users);
    }


    public User updateRole(int user_id, String role) throws InvalidNameFormatException {
        Optional<User> v = usersRepo.findById(user_id);
        if (v.isEmpty())
            throw new InvalidNameFormatException("userid is not found");
        User users = v.get();
        users.setRole(role);
        return usersRepo.save(users);
    }

}
