package dev.matias.course.service;

import dev.matias.course.domain.Anime;
import dev.matias.course.exceptions.BadRequestException;
import dev.matias.course.mapper.AnimeMapper;
import dev.matias.course.repositories.AnimeRepository;
import dev.matias.course.requests.AnimePostRequestBody;
import dev.matias.course.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        return animeRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    public Anime findByName(String name){
        System.out.println(animeRepository);
        return animeRepository.findByName(name).orElseThrow(() -> new BadRequestException("Anime not found (name)"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody){

        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id){
        animeRepository.delete(findById(id));
    }

    public void update(AnimePutRequestBody animePutRequestBody){
        Anime savedAnime = findById(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
