package dev.matias.course.service;

import dev.matias.course.domain.Anime;
import dev.matias.course.repositories.AnimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimeService {

    private final List<Anime> animes = List.of(new Anime(1L, "DBZ"), new Anime(2L,"Boku no hero"));

    public List<Anime> listAll(){
        return animes;
    }


    public Anime findById(long id){
        System.out.println(animes);
        return animes.stream()
                .filter(anime -> anime.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }
}
