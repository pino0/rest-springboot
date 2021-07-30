package com.rindus.test.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rindus.test.domain.AlbumDto;
import com.rindus.test.service.IAlbumService;
import com.rindus.test.util.FileUtils;
import com.rindus.test.util.IStorable;
import com.rindus.test.util.XMLtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService implements IAlbumService, IStorable {

    @Override
    public AlbumDto getAlbumById(Long albumId) {

        AlbumDto album = new RestTemplate()
                .getForObject(ALBUMS_RESOURCE_URL + "/"+albumId, AlbumDto.class);

        saveToFile(album);

        return album;
    }

    @Override
    public List<AlbumDto> getAllAlbums() {
        ResponseEntity<Object[]> responseEntity =
                new RestTemplate().getForEntity(ALBUMS_RESOURCE_URL, Object[].class);

        Object[] albums = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        return Arrays.stream(albums)
                .map(object -> mapper.convertValue(object, AlbumDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void saveToFile(Object obj) {
        AlbumDto albumDto = (AlbumDto) obj;

        String json = albumDto.toString();
        String xml = XMLtUtils.objectToXml(albumDto, "Album");

        FileUtils.saveFile(xml, "Album-"+(albumDto.getUserId())+".xml");

        FileUtils.saveFile(json, "Album-"+albumDto.getUserId()+".json");
    }
}
