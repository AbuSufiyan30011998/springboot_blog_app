package com.ashokit.repository;

import com.ashokit.entities.Category;
import com.ashokit.entities.Post;
import com.ashokit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
