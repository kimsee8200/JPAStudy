package org.example.jpastudy.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.jpastudy.user.db.UserEntity;
import org.example.jpastudy.user.db.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/find_all")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/name")
    public void autoSave(@RequestParam String name){
        var entity = new UserEntity().builder()
                .name(name)
                .build();
        userRepository.save(entity);
    }
}
