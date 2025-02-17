package dev.matias.course.service;

import dev.matias.course.domain.Anime;
import dev.matias.course.repositories.AnimeRepository;
import dev.matias.course.requests.AnimePostRequestBody;
import dev.matias.course.requests.AnimePutRequestBody;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {

    @Autowired
    AnimeRepository animeRepository;

    public List<Anime> listAll(){
        return animeRepository.findAll();
    }


    public Anime findById(long id){
        System.out.println(animeRepository);
        return animeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody){
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
        return animeRepository.save(anime);
    }

    public void delete(long id){
        animeRepository.delete(findById(id));
    }

    public void update(AnimePutRequestBody animePutRequestBody){
        Anime savedAnime = findById(animePutRequestBody.getId());
        Anime anime = Anime.builder().id(savedAnime.getId()).name(animePutRequestBody.getName()).build();
        animeRepository.save(anime);
    }
}
