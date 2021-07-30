package com.rindus.test.domain;

import java.io.Serializable;
import java.util.Objects;

public class CommentDto implements Serializable {

    private Long commentId;
    private Long postId;
    private String name;
    private String email;
    private String body;

    public CommentDto(){
    }

    public CommentDto(Long commentId, Long postId, String name, String email, String body){
        this.commentId = commentId;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentDto)) return false;
        CommentDto commentDto = (CommentDto) o;
        return getCommentId().equals(commentDto.getCommentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getPostId(), getName(), getEmail(), getBody());
    }

    @Override
    public String toString() {
        return "{" +
                "\"commentId\": " + commentId +
                ", \"postId\": " + postId +
                ", \"name\": \"" + name + "\"" +
                ", \"email\": \"" + email + "\"" +
                ", \"body\": \"" + body + "\"" +
                "}";
    }
}
