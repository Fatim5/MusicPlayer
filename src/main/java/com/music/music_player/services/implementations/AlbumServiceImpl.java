package com.music.music_player.services.implementations;

import com.music.music_player.dto.AlbumDTO;
import com.music.music_player.mappers.AlbumMapper;
import com.music.music_player.entities.Album;
import com.music.music_player.repository.AlbumRepository;
import com.music.music_player.services.interfaces.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public AlbumDTO save(Album album) {
        Album saved = albumRepository.save(album);
        return AlbumMapper.toDTO(saved);
    }

    @Override
    public List<AlbumDTO> findAll() {
        return albumRepository.findAll()
                .stream()
                .map(AlbumMapper::toDTO)
                .toList();
    }

    @Override
    public AlbumDTO findById(Long id) {

        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album introuvable"));

        return AlbumMapper.toDTO(album);
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}