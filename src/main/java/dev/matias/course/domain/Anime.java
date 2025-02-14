package dev.matias.course.domain;

import lombok.Data;

@Data
public class Anime {
    private String name;

    public Anime(String name){
        this.name = name;
    }

    public Anime(){}

}
