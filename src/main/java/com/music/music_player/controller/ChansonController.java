package com.music.music_player.controller;

import com.music.music_player.dto.ChansonDTO;
import com.music.music_player.mappers.ChansonMapper;
import com.music.music_player.services.interfaces.ChansonService;
import org.springframework.web.bind.annotation.*;
import com.music.music_player.storage.FileStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/chansons")
@CrossOrigin("*")
public class ChansonController {

    private final ChansonService chansonService;
    private final FileStorageService fileStorageService;

    public ChansonController(
            ChansonService chansonService,
            FileStorageService fileStorageService) {

        this.chansonService = chansonService;
        this.fileStorageService = fileStorageService;
    }

    @PostMapping(
            value = "/create",
            consumes = {"multipart/form-data"}
    )
    public ChansonDTO createChanson(

            @RequestParam("titre") String titre,

            @RequestParam("albumId") Long albumId,

            @RequestParam("music") MultipartFile music

    ) {

        String musicName =
                fileStorageService.storeFile(music, "musics");

        ChansonDTO dto = new ChansonDTO();

        dto.setTitre(titre);
        dto.setFichierAudio(musicName);
        dto.setAlbumId(albumId);

        return chansonService.save(
                ChansonMapper.toEntity(dto)
        );
    }

    @PostMapping
    public ChansonDTO save(@RequestBody ChansonDTO dto) {
        return chansonService.save(ChansonMapper.toEntity(dto));
    }

    @GetMapping
    public List<ChansonDTO> findAll() {
        return chansonService.findAll();
    }

    @GetMapping("/{id}")
    public ChansonDTO findById(@PathVariable Long id) {
        return chansonService.findById(id);
    }


}