package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PostRepo  extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(String author);
    @Query(value = "select p from Post p where p.title=:title")
    List<Post> findPostByTitle(String title);







}
