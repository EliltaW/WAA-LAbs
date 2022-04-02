package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.User;
import edu.miu.waa.lab1.model.dto.PostDto;
import edu.miu.waa.lab1.model.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto user);
    List<UserDto> findAllUsers();
    UserDto getUserById(long id);
    List<PostDto> getPostByUserId(long id);
    public void addPost(long userId, PostDto post);





}