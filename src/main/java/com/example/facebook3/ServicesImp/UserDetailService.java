package com.example.facebook3.ServicesImp;

import com.example.facebook3.entities.User;
import com.example.facebook3.entities.UsersDetails;
import com.example.facebook3.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> person = usersRepo.findByUserName(username);
        return person.map(UsersDetails::new).orElseThrow(() -> new RuntimeException("Invalid username"));
    }
}
