package com.music.music_player.services.interfaces;

import com.music.music_player.dto.ArtisteDTO;
import com.music.music_player.entities.Artiste;
import java.util.List;

public interface ArtisteService {

    ArtisteDTO save(Artiste artiste);

    List<ArtisteDTO> findAll();

    ArtisteDTO findById(Long id);

    ArtisteDTO update(Long id, Artiste artiste);

    void delete(Long id);
}