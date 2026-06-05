package com.music.music_player.dto;

public class ChansonDTO {

    private Long id;
    private String titre;
    private String fichierAudio;

    private Long albumId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFichierAudio() {
        return fichierAudio;
    }

    public void setFichierAudio(String fichierAudio) {
        this.fichierAudio = fichierAudio;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
}
