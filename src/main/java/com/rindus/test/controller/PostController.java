package com.rindus.test.controller;

import com.rindus.test.domain.PostDto;
import com.rindus.test.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class PostController {
    @Autowired
    IPostService postService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PostDto getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto post) {
        ResponseEntity<PostDto> response;

        PostDto postNew;
        try{
            postNew = postService.savePost(post);
            response = new ResponseEntity<>(postNew, HttpStatus.CREATED);
        }catch (Exception e){
            response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePost(@RequestBody PostDto post, @PathVariable(name = "id") Long id) {
        ResponseEntity<String> response;
        HttpStatus status;

        try{
            status = postService.updatePost(post);
            response = new ResponseEntity<>(null, status);
        }catch (Exception e){
            response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @PatchMapping(value = "/title/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  updatePostTitle(@RequestBody PostDto post, @PathVariable(name = "id") Long id) {
        ResponseEntity<String> response;
        HttpStatus status;

        try{
            status = postService.updatePostTitle(post, id);
            response = new ResponseEntity<>("", status);
        }catch (Exception e){
            response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {
        ResponseEntity<String> response;
        HttpStatus status;

        try{
            status= postService.deletePost(id);
            response = new ResponseEntity<>("", status);
        }catch (Exception e){
            response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }
}
