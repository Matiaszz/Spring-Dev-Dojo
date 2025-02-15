package dev.matias.course.controller;

import dev.matias.course.domain.Anime;
import dev.matias.course.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("anime")
public class AnimeController {

    @Autowired
    private DateUtil dateUtil;


    @GetMapping("/list")
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseType(LocalDateTime.now()));

        return List.of(new Anime("DBZ"), new Anime("Naruto"));
    }
}
