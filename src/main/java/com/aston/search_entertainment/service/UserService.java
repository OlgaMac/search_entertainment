package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> findAll ();
    Optional<User> findById(long id) throws ChangeSetPersister.NotFoundException;
}
