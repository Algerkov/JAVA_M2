package com.myapp.service;

import com.myapp.entity.User;
import com.myapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository UserRepository ;

    public UserService(UserRepository UserRepo){
        UserRepository = UserRepo;
    }

    public List<User> getAll() {
        return UserRepository.findAll();
    }

    public User create(User User){
        return UserRepository.save(User);
    }

    public Optional<User> findById(Long id) {
        return UserRepository.findById(id);
    }
}
