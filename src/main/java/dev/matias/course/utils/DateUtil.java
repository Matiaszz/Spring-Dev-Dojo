package dev.matias.course.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public String formatLocalDateTimeToDatabaseType(LocalDateTime dateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
    }
}
