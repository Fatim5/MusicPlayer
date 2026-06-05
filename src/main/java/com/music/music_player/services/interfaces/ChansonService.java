package com.music.music_player.services.interfaces;

import com.music.music_player.dto.ChansonDTO;
import com.music.music_player.entities.Chanson;

import java.util.List;

public interface ChansonService {

    ChansonDTO save(Chanson chanson);

    List<ChansonDTO> findAll();

    ChansonDTO findById(Long id);

    void delete(Long id);
}
