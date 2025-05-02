package com.eternity.SpringSecurity.controller;

import com.eternity.SpringSecurity.model.Users;
import com.eternity.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("user/{id}")
    public Optional<Users> getUser(@PathVariable int id)
    {
        return service.getUser(id);
    }

    @GetMapping("userList")
    public List<Users> list()
    {
        return service.listUser();
    }

    @PostMapping("addUser")
    public Users add(@RequestBody Users user)
    {
        return service.addUser(user);
    }

    @PutMapping("updateUser/{id}")
    public Users updateUser(@PathVariable int id, @RequestBody Users user)
    {
        return service.updateUser(id, user);
    }

    @DeleteMapping("deleteUser/{id}")
    public Optional<Users> deleteUser(@PathVariable int id)
    {
        return service.deleteUser(id);
    }

}
