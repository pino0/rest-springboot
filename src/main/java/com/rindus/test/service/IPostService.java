package com.rindus.test.service;

import com.rindus.test.domain.PostDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IPostService {

    String POSTS_RESOURCE_URL
            = "https://jsonplaceholder.typicode.com/posts";

    PostDto getPostById(Long postId);

    List<PostDto> getAllPosts();

    PostDto savePost(PostDto post);

    HttpStatus updatePost(PostDto post);

    HttpStatus updatePostTitle(PostDto post, Long postId);

    HttpStatus deletePost(Long postId);
}
