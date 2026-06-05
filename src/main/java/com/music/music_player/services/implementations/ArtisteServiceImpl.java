package com.music.music_player.services.implementations;

import com.music.music_player.dto.ArtisteDTO;
import com.music.music_player.mappers.ArtisteMapper;
import com.music.music_player.entities.Artiste;
import com.music.music_player.repository.ArtisteRepository;
import com.music.music_player.services.interfaces.ArtisteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteServiceImpl implements ArtisteService {

    private final ArtisteRepository artisteRepository;

    public ArtisteServiceImpl(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    @Override
    public ArtisteDTO save(Artiste artiste) {

        Artiste saved = artisteRepository.save(artiste);
        return ArtisteMapper.toDTO(saved);
    }

    @Override
    public List<ArtisteDTO> findAll() {

        return artisteRepository.findAll()
                .stream()
                .map(ArtisteMapper::toDTO)
                .toList();
    }

    @Override
    public ArtisteDTO findById(Long id) {

        Artiste artiste = artisteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artiste introuvable"));

        return ArtisteMapper.toDTO(artiste);
    }

    @Override
    public void delete(Long id) {
        artisteRepository.deleteById(id);
    }


    @Override
    public ArtisteDTO update(Long id, Artiste artiste) {
        Artiste existing = artisteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artiste introuvable"));

        existing.setNom(artiste.getNom());
        existing.setDescription(artiste.getDescription());
        existing.setImage(artiste.getImage());

        return ArtisteMapper.toDTO(artisteRepository.save(existing));
    }

}