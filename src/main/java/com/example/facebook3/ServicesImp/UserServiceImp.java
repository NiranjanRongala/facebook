package com.example.facebook3.ServicesImp;

import com.example.facebook3.Services.UserService;
import com.example.facebook3.entities.User;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import com.example.facebook3.repos.FollowerRepo;
import com.example.facebook3.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo usersRepo;
    @Autowired
    private FollowerRepo followersRepo;

    Pattern pattern2 = Pattern.compile("[6-9][0-9]{9}");
    Pattern pattern = Pattern.compile("[A-Z][a-z]*");

    @Override
    public User addUser(User users) throws InvalidNameFormatException {
        Matcher matcher = pattern.matcher(users.getUsername());

        Matcher matcher1 = pattern2.matcher(users.getPhonenumber());
        User users1 = new User();
        if (matcher.matches()) {
            users1.setUsername(users.getUsername());

        } else
            throw new InvalidNameFormatException("Invalid name format");
        if (matcher1.matches())
            users1.setPhonenumber(users.getPhonenumber());
        else
            throw new InvalidNameFormatException("invalid number");
        users1.setCreatedat(users.getCreatedat());
        users1.setUpdatedat(users.getUpdatedat());

        return usersRepo.save(users1);
    }

    @Override
    public void removeUser(int user_id) throws InvalidNameFormatException {
        Optional<User> v = usersRepo.findById(user_id);
        if (v.isEmpty())
            throw new InvalidNameFormatException("user is not found");

        usersRepo.deleteById(user_id);


    }

    @Override
    public User updateUserName(int user_id, String user_name) throws InvalidNameFormatException {
        Optional<User> v = usersRepo.findById(user_id);
        if (v.isEmpty())
            throw new InvalidNameFormatException("userid is not found");
        User users = v.get();
        users.setUsername(user_name);
        return usersRepo.save(users);

    }


    @Override
    public List<User> getUsers() throws InvalidNameFormatException {
        List<User> users = usersRepo.findAll();

        if (users.isEmpty())
            throw new InvalidNameFormatException("there is no data in Users table");

        return usersRepo.findAll();
    }

    @Override
    public Page<User> getuserPage(int offset, int limit) {

        return usersRepo.findAll(PageRequest.of(offset, limit));

    }

    @Override
    public Page<User> getuserPagebySort(int offset, int limit, String sortby) {
        return usersRepo.findAll(PageRequest.of(offset, limit, Sort.by(sortby).descending()));
    }

}
