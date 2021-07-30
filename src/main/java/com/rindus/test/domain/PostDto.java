package com.rindus.test.domain;

import java.io.Serializable;
import java.util.Objects;

public class PostDto implements Serializable {

    private Long id;
    private Long userId;
    private String title;
    private String body;

    public PostDto(){}

    public PostDto(Long id, Long userId, String title, String body){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDto)) return false;
        PostDto postDto = (PostDto) o;
        return getId().equals(postDto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getTitle(), getBody());
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id +
                ", \"userId\": " + userId +
                ", \"title\": \"" + title + "\"" +
                ", \"body\": \"" + body + "\"" +
                "}";
    }
}
