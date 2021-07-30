package com.rindus.test.service;

import com.rindus.test.domain.AlbumDto;

import java.util.List;

public interface IAlbumService {

    String ALBUMS_RESOURCE_URL
            = "https://jsonplaceholder.typicode.com/albums";

    AlbumDto getAlbumById(Long albumId);

    List<AlbumDto> getAllAlbums();
}
