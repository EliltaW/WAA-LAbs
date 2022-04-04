package edu.miu.waa.lab1.controller;


import edu.miu.waa.lab1.aspect.annotations.ExecutionTime;
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

    @GetMapping("/posts")
    public List<UserDto> findUserByPostTitle(@RequestParam String title){
        return userService.findUserByPostTitle(title);
    }

    @ExecutionTime
    @GetMapping("/{id}/user")
    public UserDto getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") long userId){
        userService.deleteUserById(userId);
    }

    @GetMapping("{id}/getposts")
    public List<PostDto> getPostByUserId(@PathVariable("id") long id){
        return userService.getPostByUserId(id);
    }

      @PostMapping("/{userId}/addpost")
    public void addPost(@PathVariable("userId") long userId, @RequestBody PostDto post) {
      userService.addPost(userId, post);
    }

    @GetMapping("/{num}")
    public List<User> usersHavingPostsMoreThanN(@PathVariable("num") int num){
        return userService.usersHavingPostsMoreThanN(num);
    }




}
