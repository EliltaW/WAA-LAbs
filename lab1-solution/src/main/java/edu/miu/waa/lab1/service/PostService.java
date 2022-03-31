package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.dto.PostDto;

import java.util.List;

public interface PostService {

   List<PostDto> findAll();
    PostDto findById(int id);
    void savePost(Post post);
    void deleteById(int id);
    void updateById(int id);

}
