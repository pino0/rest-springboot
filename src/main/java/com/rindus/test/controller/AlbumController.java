package com.rindus.test.controller;

import com.rindus.test.domain.AlbumDto;
import com.rindus.test.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/albums")
public class AlbumController {

    @Autowired
    IAlbumService albumService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AlbumDto> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AlbumDto getAlbumById(@PathVariable Long id){
        return albumService.getAlbumById(id);
    }
}
