package com.codeup.project.services;

import com.codeup.project.models.Post;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface PostsRepo extends CrudRepository<Post, Long> {

    List <Post> findAllByTitleContainsOrBodyContains(String search1, String search2);

//    @Query("from blogproject_db where title like %?1% or body like %?1%")
//    List<Post> searchByTitleOrBody(String search);
}
