package com.music.music_player.mappers;

import com.music.music_player.dto.ChansonDTO;
import com.music.music_player.entities.Album;
import com.music.music_player.entities.Chanson;

public class ChansonMapper {

    // ENTITY → DTO
    public static ChansonDTO toDTO(Chanson chanson) {

        ChansonDTO dto = new ChansonDTO();
        dto.setId(chanson.getId());
        dto.setTitre(chanson.getTitre());
        dto.setFichierAudio(chanson.getFichierAudio());

        if (chanson.getAlbum() != null) {
            dto.setAlbumId(chanson.getAlbum().getId());
        }

        return dto;
    }

    // DTO → ENTITY
    public static Chanson toEntity(ChansonDTO dto) {

        Chanson chanson = new Chanson();
        chanson.setId(dto.getId());
        chanson.setTitre(dto.getTitre());
        chanson.setFichierAudio(dto.getFichierAudio());

        if (dto.getAlbumId() != null) {
            Album album = new Album();
            album.setId(dto.getAlbumId());
            chanson.setAlbum(album);
        }

        return chanson;
    }
}