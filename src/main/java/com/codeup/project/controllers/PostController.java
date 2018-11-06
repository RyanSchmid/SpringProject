package com.codeup.project.controllers;

import com.codeup.project.models.Post;
import com.codeup.project.models.User;
import com.codeup.project.services.PostSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostSvc postSvc;

    public PostController(PostSvc postsvc) {
        this.postSvc = postsvc;
    }

    @GetMapping("/index")
    public String hello(Model vModel) {
        vModel.addAttribute("posts", postSvc.all());
        return "posts/index";
    }

    @GetMapping("/")
    private String sayHello(Model vModel) {
        vModel.addAttribute("posts", postSvc.all());
        return "posts/index";
    }

    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
        vModel.addAttribute("posts", postSvc.all());
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
        Post savedPost = postSvc.create(post);
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
    public String showPostUpdateForm(@ModelAttribute Post post) {
        Post updatedPost = postSvc.update(post);
        return "redirect:/posts/" +updatedPost.getId();
    }

    //    POST	/posts/{id}/delete to remove post
    @PostMapping("/posts/{id}/delete")
    public String removePost(@PathVariable int id, @ModelAttribute Post post) {
        postSvc.delete(id);
        return "redirect:/posts/";
    }


    //GET mapping for search results
    @GetMapping("/ads/search/{term}")
    public String showResults(@PathVariable String term, Model vModel){
        vModel.addAttribute("ads", postSvc.search(term));
        return "ads/index";
    }

    //GET mapping for search results
    @GetMapping("/login")
    public String login(Model vModel){
        vModel.addAttribute("user", new User());
        return "users/login";
    }

    @GetMapping("/register")
    public String register(Model vModel){
        vModel.addAttribute("user", new User());
        return "users/register";
    }

//    @PostMapping("/posts/{id}/edit")
//    public String showPostUpdateForm(@ModelAttribute Post post) {
//        Post updatedPost = postSvc.update(post);
//        return "redirect:/posts/" +updatedPost.getId();
//    }
}
