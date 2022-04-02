package edu.miu.waa.lab1.controller;


import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.User;
import edu.miu.waa.lab1.model.dto.PostDto;
import edu.miu.waa.lab1.model.dto.UserDto;
import edu.miu.waa.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void save(@RequestBody UserDto user){
        System.out.println(user);
        userService.save(user);
    }

    @GetMapping
    public List<UserDto> findAllUser(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @GetMapping("{id}/posts")
    public List<PostDto> getPostByUserId(@PathVariable("id") long id){
        return userService.getPostByUserId(id);
    }

      @PostMapping("/{userId}")
    public void addPost(@PathVariable("userId") long userId, @RequestBody PostDto post) {
      userService.addPost(userId, post);
    }

//    @GetMapping
//    public List<UserDto> usersWithMoreThanOnePost(){
//        return null;
//    }


}
