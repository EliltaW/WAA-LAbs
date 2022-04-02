package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.helper.ListMapper;
import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.dto.Content;
import edu.miu.waa.lab1.model.dto.ContentDto;
import edu.miu.waa.lab1.model.dto.PostDto;
import edu.miu.waa.lab1.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    ModelMapper modelMapper;

    PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo){

        this.postRepo = postRepo;
    }

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        System.out.println("Service class...");
       return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());

    }

//    @Override
//    public List<PostV2> findAllV2() {
//        return postRepo.findAllV2();
//    }

    @Override
    public List<Post> findByAuthor(String author) {
        return postRepo.findByAuthor(author);
    }

    @Override
    public PostDto findById(long id) {

        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void savePost(PostDto post) {
        System.out.println("Service...#############" + post);
        postRepo.save(modelMapper.map(post, Post.class));
    }

    @Override
    @ResponseStatus(HttpStatus.GONE)
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }


    @Override
    public void updateById(long id, ContentDto contentDto) {
        Post p =  modelMapper.map(contentDto, Post.class);
        Post postToUpdate = postRepo.findById(id).orElse(new Post());
        postToUpdate.setTitle(p.getTitle());
        postToUpdate.setContent(p.getContent());
        postRepo.save(postToUpdate);
    }


    @Override
    public Content getContentByPostId(long id) {
        return modelMapper.map(postRepo.findById(id), Content.class);
    }
}
