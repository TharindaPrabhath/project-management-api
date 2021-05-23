package com.symetry.projectmanagementapi.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class UserService {
    
    private final UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public User getUser(Long userId){
        Optional<User> user = UserRepository.findById(userId);
        if(!user.isPresent()){
            try {
                throw new NotFoundException("No such a user");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return user.get();
    }

    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }
}
