package org.product.gp.rest.provided.facade;

import org.product.gp.rest.required.facade.Post;
import org.product.gp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostRessource {
    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    public Post getPostById(@PathVariable("postId") Long postId){
        return postService.getPostById(postId);
    }
}
