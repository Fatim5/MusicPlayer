package com.music.music_player.services.implementations;

import com.music.music_player.dto.ChansonDTO;
import com.music.music_player.mappers.ChansonMapper;
import com.music.music_player.entities.Chanson;
import com.music.music_player.repository.ChansonRepository;
import com.music.music_player.services.interfaces.ChansonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChansonServiceImpl implements ChansonService {

    private final ChansonRepository chansonRepository;

    public ChansonServiceImpl(ChansonRepository chansonRepository) {
        this.chansonRepository = chansonRepository;
    }

    @Override
    public ChansonDTO save(Chanson chanson) {
        Chanson saved = chansonRepository.save(chanson);
        return ChansonMapper.toDTO(saved);
    }

    @Override
    public List<ChansonDTO> findAll() {
        return chansonRepository.findAll()
                .stream()
                .map(ChansonMapper::toDTO)
                .toList();
    }

    @Override
    public ChansonDTO findById(Long id) {

        Chanson chanson = chansonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chanson introuvable"));

        return ChansonMapper.toDTO(chanson);
    }
    @Override
    public void delete(Long id) {
        chansonRepository.deleteById(id);
    }
}
