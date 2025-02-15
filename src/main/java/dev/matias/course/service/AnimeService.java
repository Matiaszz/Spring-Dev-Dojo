package dev.matias.course.service;

import dev.matias.course.domain.Anime;
import dev.matias.course.repositories.AnimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class AnimeService {

    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(2L, "Boku no hero"), new Anime(1L, "Berserk")));

    }

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

    public Anime save(Anime anime){
        anime.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        animes.add(anime);
        return anime;
    }

    public void delete(long id){
        animes.remove(findById(id)) ;
    }

    public void update(Anime anime){
        delete(anime.getId());
        animes.add(anime);
    }
}
