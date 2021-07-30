package com.rindus.test.domain;

import java.io.Serializable;
import java.util.Objects;

public class AlbumDto implements Serializable {

    private Long id;
    private Long userId;
    private String title;

    public AlbumDto(){

    }

    public AlbumDto(Long id, Long userId, String title){
        this.id = id;
        this.userId = userId;
        this.title = title;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlbumDto)) return false;
        AlbumDto albumDto = (AlbumDto) o;
        return id.equals(albumDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"userId\":" + userId +
                ", \"title\": \"" + title + "\"" +
                "}";
    }
}
