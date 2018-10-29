package com.codeup.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody public String posts() {return "Posts index page";};

    @GetMapping("/posts/{id}")
    @ResponseBody public String postId(@PathVariable int id) {return "View individual post";};

    @GetMapping("/posts/create")
    @ResponseBody public String postCreateGet() {return "View form to create post";};

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody public String postCreate() {return "create a new post";};
}

