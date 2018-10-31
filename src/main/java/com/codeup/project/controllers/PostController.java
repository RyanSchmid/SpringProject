package com.codeup.project.controllers;

import com.codeup.project.Post;
import com.codeup.project.services.PostSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostSvc postSvc;

    public PostController(PostSvc postsvc) {
        this.postSvc = postsvc;
    }

    @GetMapping("/index")
    public String hello() {
        return "posts/index";
    }

    @GetMapping("/")
    private String sayHello(Model vModel) {
        vModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
        vModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }


    //    GET	/ads/{id}	view an individual post
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model vModel) {
        vModel.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }



    //    GET	/ads/create	view the form for creating a post
    @GetMapping("/posts/create")
    public String showPostForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    //    POST	/ads/create	create a new post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        Post savedPost = postSvc.save(post);
        return "redirect:/posts/" + savedPost.getId();
    }





    //    GET	/posts/{id}/edit view the form to edit post
    @GetMapping("/posts/{id}/edit")
    public String showPostUpdateForm(@PathVariable int id, Model vModel) {
        vModel.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }

    //    POST	/posts/{id}/edit send form to edit post
    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        Post savedPost = postSvc.update(post);
        return "create a new post";
    }

}
