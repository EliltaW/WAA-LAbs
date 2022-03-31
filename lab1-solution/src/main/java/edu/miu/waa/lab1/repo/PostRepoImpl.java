package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{
    static List<Post> posts;

    static {
        posts = new ArrayList<>();
        Post post1 = new Post(1, "todays news", "What's goin on today", "Arthur");
        Post post2 = new Post(2, "Weather forecast", "Todays weather is going to be..", "Amilia");
        posts.add(post1);
        posts.add(post2);
        System.out.println(posts);

    }


    @Override
    public void savePost(Post post) {

        var notExists = posts
                .stream()
                .noneMatch(p -> p.getId() == post.getId());

        if (notExists) {
            posts.add(post);
        }    }

    @Override
    public List<Post> findAll() {

        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        posts
                .stream()
                .filter(p -> p.getId() == id)
                .forEach(p -> posts.remove(p));    }

    @Override
    public void updateByid(int id) {
      //Post p = posts.get(id);

    }
}
