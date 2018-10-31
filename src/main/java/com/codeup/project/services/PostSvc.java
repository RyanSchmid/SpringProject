package com.codeup.project.services;

import com.codeup.project.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSvc {

    private List<Post> posts;

    public PostSvc(){
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post save(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post update(Post post){
        return posts.set((int) post.getId(), post);
    }

    public Post findOne(long id){
        return posts.get( (int) id - 1);
    }

    private void createPosts(){
        this.save(new Post("My first post", "It's about my feelings"));
        this.save(new Post("A good day", "Yay"));
        this.save(new Post("A bad day", "Meh"));
    }

}
