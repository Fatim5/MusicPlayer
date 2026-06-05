package com.music.music_player.mappers;

import com.music.music_player.dto.AlbumDTO;
import com.music.music_player.entities.Album;
import com.music.music_player.entities.Artiste;

public class AlbumMapper {

    // ENTITY → DTO
    public static AlbumDTO toDTO(Album album) {

        AlbumDTO dto = new AlbumDTO();
        dto.setId(album.getId());
        dto.setTitre(album.getTitre());
        dto.setImage(album.getImage());

        if (album.getArtiste() != null) {
            dto.setArtisteId(album.getArtiste().getId());
        }

        return dto;
    }

    // DTO → ENTITY
    public static Album toEntity(AlbumDTO dto) {

        Album album = new Album();
        album.setId(dto.getId());
        album.setTitre(dto.getTitre());
        album.setImage(dto.getImage());

        if (dto.getArtisteId() != null) {
            Artiste artiste = new Artiste();
            artiste.setId(dto.getArtisteId());
            album.setArtiste(artiste);
        }

        return album;
    }
}