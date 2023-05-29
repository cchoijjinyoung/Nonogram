package com.logic.nemonemo.service;

import com.logic.nemonemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


}