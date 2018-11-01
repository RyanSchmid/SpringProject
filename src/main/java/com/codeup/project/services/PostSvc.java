package com.codeup.project.services;

import com.codeup.project.Post;
import com.codeup.project.PostsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSvc {

    private PostsRepo postRepo;

    public PostSvc(PostsRepo postRepo){
        this.postRepo = postRepo;
    }

    public Iterable<Post> all(){
        return postRepo.findAll();
    }

    public Post create(Post post){
        return postRepo.save(post);
    }

    public Post update(Post post){
        return postRepo.save(post);
    }

    public Post findOne(long id){
        return postRepo.findOne(id);
    }

    public List<Post> search(String search){
     return postRepo.findAllByTitleContainsOrBodyContains(search, search);
    }


}
