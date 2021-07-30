package com.rindus.test.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.rindus.test.controller.AlbumController;
import com.rindus.test.service.implementation.AlbumService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = AlbumService.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
@ContextConfiguration(classes = {AlbumController.class})
public class AlbumControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AlbumService service;

    @Test
    public void whenGetAlbums_thenStatus200()
            throws Exception {

        mvc.perform(get("/api/albums")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenAlbumId_1_whenGetAlbumById_thenStatus200()
            throws Exception {

        mvc.perform(get("/api/albums/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }
}
