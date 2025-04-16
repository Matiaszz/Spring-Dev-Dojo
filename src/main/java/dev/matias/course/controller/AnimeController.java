package dev.matias.course.controller;

import dev.matias.course.domain.Anime;
import dev.matias.course.requests.AnimePostRequestBody;
import dev.matias.course.requests.AnimePutRequestBody;
import dev.matias.course.service.AnimeService;
import dev.matias.course.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/animes")
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;


    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> list(@PathVariable long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody anime){
        Anime animeSaved = animeService.save(anime);
        return new ResponseEntity<>(animeSaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.update(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find")
    public ResponseEntity<Anime> find(@RequestParam String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }
}
