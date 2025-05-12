package com.eternity.SpringSecurity.service;

import com.eternity.SpringSecurity.model.Users;
import com.eternity.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    // User
    public Optional<Users> getUser(int id)
    {
        return repo.findById(id);
    }


    //  User List
    public List<Users> listUser()
    {
        return repo.findAll();
    }

    // Register User
    public Users registerUser(Users user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    // Update User
    public Users updateUser(int id, Users user)
    {
        repo.save(user);
        return user;
    }

    // Delete User
    public Optional<Users> deleteUser(int id)
    {
        Optional<Users> tempUser = getUser(id);
        repo.deleteById(id);
        return tempUser;
    }
}
