package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.PostV2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo{
    private static final List<Post> posts;
    private static final List<PostV2> postsv2;
    private static long postId = 100;


    static {
        posts = new ArrayList<>();
        postsv2 = new ArrayList<>();
        Post post1 = new Post(99, "todays news", "What's goin on today", "Arthur");
        Post post2 = new Post(220, "Weather forecast", "Todays weather is going to be..", "Amilia");
        posts.add(post1);
        posts.add(post2);

        PostV2 postV2 = new PostV2(111, "Daily Follow up", "sprint meeting,...", "Scrum Master");
        PostV2 postV21 = new PostV2(122, "Software", "What software to use,...", "Dev");

        postsv2.add(postV2);
        postsv2.add(postV21);

    }

    @Override
    public void savePost(Post post) {
        post.setId(postId);
        postId++;
        posts.add(post);

    }

    @Override
    public void updateById(long id, Post post) {
        Post postToUpdate = findById(id);
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setContent(post.getContent());
    }

    @Override
    public List<Post> findAll() {
      // System.out.println("Repository...." + posts);
        return posts;
    }

    @Override
    public List<PostV2> findAllV2() {
        return postsv2;
    }

    @Override
    public Post findById(long id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts
                .stream()
                .filter(post -> post.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst().ifPresent(posts::remove);    }


}
