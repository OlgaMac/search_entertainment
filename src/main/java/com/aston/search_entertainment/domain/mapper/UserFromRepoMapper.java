package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.entity.Entertainment;
import com.aston.search_entertainment.domain.entity.User;
import com.aston.search_entertainment.repository.EntertainmentRepository;
import com.aston.search_entertainment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFromRepoMapper {

    private final UserRepository userRepository;

    private final EntertainmentRepository entertainmentRepository;

    @Named("getUserFromRepo")
    public User getUserFromRepo(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Named("getEntertainmentFromRepo")
    public Entertainment getEntertainmentFromRepo(Long id) {
        return entertainmentRepository.findEntertainmentById(id);
    }
}
