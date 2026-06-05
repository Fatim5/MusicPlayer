package com.music.music_player.mappers;

import com.music.music_player.dto.ArtisteDTO;
import com.music.music_player.entities.Artiste;

public class ArtisteMapper {

    // Entity → DTO
    public static ArtisteDTO toDTO(Artiste artiste) {

        ArtisteDTO dto = new ArtisteDTO();
        dto.setId(artiste.getId());
        dto.setNom(artiste.getNom());
        dto.setDescription(artiste.getDescription());
        dto.setImage(artiste.getImage());

        return dto;
    }

    // DTO → Entity
    public static Artiste toEntity(ArtisteDTO dto) {

        Artiste artiste = new Artiste();
        artiste.setId(dto.getId());
        artiste.setNom(dto.getNom());
        artiste.setDescription(dto.getDescription());
        artiste.setImage(dto.getImage());

        return artiste;
    }
}