package com.example.user.controller;

import com.example.user.entity.AuthRequest;
import com.example.user.entity.UserInfo;
import com.example.user.service.JwtUtilityService;
import com.example.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtUtilityService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addNewUser(userInfo);
    }
    @GetMapping("/user-details")
    public List<UserInfo> getAllUserDetails() {
        return service.getAllUserDetails();
    }

    // Removed the role checks here as they are already managed in SecurityConfig

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        log.info("request body{} : ",authRequest.getUsername());
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword())
        );
        log.info("authentication{}  : ", authentication.isAuthenticated());
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());

        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
