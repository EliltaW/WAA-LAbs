package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.User;
import edu.miu.waa.lab1.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User getUserById(long id);

    @Query(value ="select u.posts from User u where u.id = :id")
    List<Post> getPostByUserId(long id);

//    @Query(value = "select u from User u where u.getPost > :num )
//    List<UserDto> getUsersByPostsIsGreaterThanOne(int num);


}