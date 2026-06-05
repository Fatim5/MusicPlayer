package com.music.music_player.dto;

public class AlbumDTO {

    private Long id;
    private String titre;
    private String image;

    private Long artisteId; // on simplifie la relation

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getArtisteId() {
        return artisteId;
    }

    public void setArtisteId(Long artisteId) {
        this.artisteId = artisteId;
    }
}
