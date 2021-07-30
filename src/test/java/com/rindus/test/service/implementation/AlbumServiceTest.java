package com.rindus.test.service.implementation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumServiceTest {

    AlbumService service;

    @Before
    public void setUp(){
        service = new AlbumService();
    }

    @Test
    @DisplayName("Get all Albums call should return list of Albums greater than zero")
    public void getAllAlbums(){
        assertTrue(0 < service.getAllAlbums().size());
    }
}
