package edu.miu.waa.lab1.controller;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.dto.Content;
import edu.miu.waa.lab1.model.dto.ContentDto;
import edu.miu.waa.lab1.model.dto.PostDto;
import edu.miu.waa.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    PostService postService;

    @Autowired
    public PostController( PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public void savePost(@RequestBody Post post){
        postService.savePost(post);}

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable("id") int id){
      return ResponseEntity.ok(postService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        postService.deleteById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateById(@PathVariable int id, @RequestBody ContentDto contentDto) {
        postService.updateById(id, contentDto);
    }
    @GetMapping("/{id}/content")
    public ResponseEntity<Content> getContentByPostId(@PathVariable int id) {
        return ResponseEntity.ok(postService.getContentByPostId(id));
    }


}
