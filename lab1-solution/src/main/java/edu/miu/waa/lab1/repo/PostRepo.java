package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.PostV2;

import java.util.List;

public interface PostRepo {

    void savePost(Post post);
    List<PostV2> findAllV2();
    List<Post> findByAuthor(String author);
    List<Post> findAll();
    Post findById(long id);
    void deleteById(long id);
    void updateById(long id, Post post);
}
