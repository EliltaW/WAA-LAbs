package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Comment;
import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Repository
public interface PostRepo  extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(String author);
    @Query(value = "select p from Post p where p.title=:title")
    List<Post> findPostByTitle(String title);
    @Query(value = "select p.comments from Post p where p.id=:postId")
    List<Comment>  getCommentByPostId(long postId);







}
