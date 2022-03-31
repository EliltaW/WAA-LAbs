package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Post;

import java.util.List;

public interface PostRepo {

    void savePost(Post post);
    List<Post> findAll();
    Post findById(int id);
    void deleteById(int id);
    void updateByid(int id);
}
