package dev.matias.course.repositories;

import dev.matias.course.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository {
    List<Anime> getAllAnimes();
    Anime findById(long id);
}
