package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
