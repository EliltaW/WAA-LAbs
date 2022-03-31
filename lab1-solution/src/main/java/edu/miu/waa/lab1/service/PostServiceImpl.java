package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.helper.ListMapper;
import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.dto.PostDto;
import edu.miu.waa.lab1.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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

        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto findById(int id) {

        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(Post post) {
        postRepo.savePost(post);
    }

    @Override
    @ResponseStatus(HttpStatus.GONE)
    public void deleteById(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById ( int id) {
         postRepo.updateByid(id);
    }
}
