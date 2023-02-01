package org.product.gp.service;

import org.product.gp.rest.required.facade.JSONPlaceHolderClient;
import org.product.gp.rest.required.facade.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PostService {
    @Autowired
    JSONPlaceHolderClient jsonPlaceHolderClient;
    public List<Post> getPosts(){
        return jsonPlaceHolderClient.getPosts();
    }

    public Post getPostById(@PathVariable("postId") Long postId){
        return jsonPlaceHolderClient.getPostById(postId);
    }
}
