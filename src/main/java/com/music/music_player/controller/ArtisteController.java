package com.music.music_player.controller;

import com.music.music_player.dto.ArtisteDTO;
import com.music.music_player.entities.Artiste;
import com.music.music_player.mappers.ArtisteMapper;
import com.music.music_player.services.interfaces.ArtisteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistes")
@CrossOrigin("*")
public class ArtisteController {

    private final ArtisteService artisteService;

    public ArtisteController(ArtisteService artisteService) {
        this.artisteService = artisteService;
    }

    @PostMapping
    public ArtisteDTO save(@RequestBody ArtisteDTO dto) {

        Artiste artiste = ArtisteMapper.toEntity(dto);
        return artisteService.save(artiste);
    }
    @PutMapping("/{id}")
    public ArtisteDTO update(
            @PathVariable Long id,
            @RequestBody ArtisteDTO dto) {

        return artisteService.update(id, ArtisteMapper.toEntity(dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artisteService.delete(id);
    }

    @GetMapping
    public List<ArtisteDTO> findAll() {
        return artisteService.findAll();
    }

    @GetMapping("/{id}")
    public ArtisteDTO findById(@PathVariable Long id) {
        return artisteService.findById(id);
    }
}
