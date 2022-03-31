package edu.miu.waa.lab1.controller;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.dto.PostDto;
import edu.miu.waa.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    PostService postService;

    @Autowired
    public PostController( PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto findById(@PathVariable("id") int id){
      return  postService.findById(id);
    }

//    @GetMapping("/")
//    public List<Post> getByAuthorName(@RequestParam("filter") String authorName){
//
//    }
    @PostMapping
    public void savePost(@RequestBody Post post){
        postService.savePost(post);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") int id){
        postService.updateById(id);
    }

}
