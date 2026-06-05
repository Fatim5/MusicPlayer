package com.music.music_player.services.interfaces;

import com.music.music_player.dto.AlbumDTO;
import com.music.music_player.entities.Album;

import java.util.List;

public interface AlbumService {

    AlbumDTO save(Album album);

    List<AlbumDTO> findAll();

    AlbumDTO findById(Long id);

    void delete(Long id);
}
