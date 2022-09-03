package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findAll ();
}
