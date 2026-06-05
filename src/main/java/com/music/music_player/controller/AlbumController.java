package com.music.music_player.controller;

import com.music.music_player.dto.AlbumDTO;
import com.music.music_player.mappers.AlbumMapper;
import com.music.music_player.services.interfaces.AlbumService;
import org.springframework.web.bind.annotation.*;
import com.music.music_player.storage.FileStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@CrossOrigin("*")
public class AlbumController {

    private final AlbumService albumService;
    private final FileStorageService fileStorageService;

    public AlbumController(
            AlbumService albumService,
            FileStorageService fileStorageService) {

        this.albumService = albumService;
        this.fileStorageService = fileStorageService;
    }

    @PostMapping(
            value = "/create",
            consumes = {"multipart/form-data"}
    )
    public AlbumDTO createAlbum(
            @RequestParam("titre") String titre,
            @RequestParam("artisteId") Long artisteId,
            @RequestParam("image") MultipartFile image
    ) {

        String imageName =
                fileStorageService.storeFile(image, "images");

        AlbumDTO dto = new AlbumDTO();

        dto.setTitre(titre);
        dto.setImage(imageName);
        dto.setArtisteId(artisteId);

        return albumService.save(
                AlbumMapper.toEntity(dto)
        );
    }

    @PostMapping
    public AlbumDTO save(@RequestBody AlbumDTO dto) {
        return albumService.save(AlbumMapper.toEntity(dto));
    }

    @GetMapping
    public List<AlbumDTO> findAll() {
        return albumService.findAll();
    }

    @GetMapping("/{id}")
    public AlbumDTO findById(@PathVariable Long id) {
        return albumService.findById(id);
    }


}
