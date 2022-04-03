package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.helper.ListMapper;
import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.User;
import edu.miu.waa.lab1.model.dto.PostDto;
import edu.miu.waa.lab1.model.dto.UserDto;
import edu.miu.waa.lab1.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

   private UserRepo userRepo;

   @Autowired
   public UserServiceImpl(UserRepo userRepo){
       this.userRepo = userRepo;
   }

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapperUserToDto;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;


    @Override
    public void save(UserDto user) {
        userRepo.save(modelMapper.map(user, User.class));
    }

    @Override
    public List<UserDto> findAllUsers() {
        return (List<UserDto>) listMapperUserToDto.mapList( userRepo.findAll(), new UserDto());
    }

    @Override
    public List<UserDto> findUserByPostTitle(String title) {
        return userRepo.findUserByPostsTitle(title);
    }

    @Override
    public UserDto getUserById(long id) {

        return modelMapper.map(userRepo.getUserById(id), UserDto.class);
    }



    @Override
    public List<PostDto> getPostByUserId(long id) {

        return (List<PostDto>) listMapperPostToDto.mapList( userRepo.getPostByUserId(id), new PostDto());
    }

    @Override
    public void addPost(long userId, PostDto post) {

        System.out.println("before adding to the list" + post);
        User user = userRepo.getUserById(userId);
        List<Post> posts = user.getPosts();
        posts.add(modelMapper.map(post, Post.class));
        user.setPosts(posts);
        System.out.println("***");
        System.out.println(user);
        userRepo.save(user);

    }

    @Override
    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> usersHavingPostsMoreThanN(int num) {
        return userRepo.getUsersByPostsIsGreaterThanNum(num);
    }
}
