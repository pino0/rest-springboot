package com.rindus.test.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rindus.test.domain.PostDto;
import com.rindus.test.service.IPostService;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Override
    public PostDto getPostById(Long postId) {

        return new RestTemplate()
                .getForObject(POSTS_RESOURCE_URL + "/" + postId, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPosts() {

        ResponseEntity<Object[]> responseEntity =
                new RestTemplate().getForEntity(POSTS_RESOURCE_URL, Object[].class);

        Object[] posts = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        return Arrays.stream(posts)
                .map(object -> mapper.convertValue(object, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto savePost(PostDto post) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<PostDto> request = new HttpEntity<>(post);
        PostDto postResp = restTemplate.postForObject(POSTS_RESOURCE_URL, request, PostDto.class);

        return postResp;
    }

    @Override
    public HttpStatus updatePost(PostDto post) {
        RestTemplate restTemplate = new RestTemplate();
        String url = POSTS_RESOURCE_URL + '/' + post.getId();
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity requestUpdate = new HttpEntity(headers);

        ResponseEntity<PostDto> response = restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, PostDto.class, post.getId());

        return response.getStatusCode();
    }

    @Override
    public HttpStatus updatePostTitle(PostDto post, Long postId) {
        final int timeOut = 5000;
        RestTemplate restTemplate = new RestTemplate();
        String url = POSTS_RESOURCE_URL + '/' + postId + "?_method=patch";
        HttpHeaders headers = new HttpHeaders();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setConnectTimeout(timeOut);
        requestFactory.setReadTimeout(timeOut);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity requestUpdate = new HttpEntity(headers);
        restTemplate.setRequestFactory(requestFactory);

        ResponseEntity<PostDto> response = restTemplate.exchange(url, HttpMethod.PATCH, requestUpdate, PostDto.class, postId);

        return  response.getStatusCode();
    }

    @Override
    public HttpStatus deletePost(Long postId) {
        String url = POSTS_RESOURCE_URL + '/' + postId;
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(url);

        return HttpStatus.OK;
    }
}
