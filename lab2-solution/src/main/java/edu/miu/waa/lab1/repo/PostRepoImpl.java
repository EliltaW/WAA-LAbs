package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo{
    private static final List<Post> posts;
    private static long postId = 100;


    static {
        posts = new ArrayList<>();
        Post post1 = new Post(99, "todays news", "What's goin on today", "Arthur");
        Post post2 = new Post(220, "Weather forecast", "Todays weather is going to be..", "Amilia");
        posts.add(post1);
        posts.add(post2);

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
        return posts;
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
