package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.PostV2;
import edu.miu.waa.lab1.model.dto.Content;
import edu.miu.waa.lab1.model.dto.ContentDto;
import edu.miu.waa.lab1.model.dto.PostDto;

import java.util.List;

public interface PostService {

   List<PostDto> findAll();
   // List<PostV2> findAllV2();
   List<Post> findByAuthor(String author);
    PostDto findById(long id);
    void savePost(PostDto post);
    void deleteById(long id);
    void updateById(long id, ContentDto contentDto);
    Content getContentByPostId(long id);


}
