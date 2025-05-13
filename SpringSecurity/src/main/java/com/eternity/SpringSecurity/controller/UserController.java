package com.eternity.SpringSecurity.controller;

import com.eternity.SpringSecurity.model.Users;
import com.eternity.SpringSecurity.service.JWTService;
import com.eternity.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

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

    @PostMapping("register")
    public Users register(@RequestBody Users user)
    {
        return service.registerUser(user);
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

    @PostMapping("login")
    public String Login(@RequestBody Users user)
    {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(user.getUsername());
        }
        return "Login Failed";
    }

}
