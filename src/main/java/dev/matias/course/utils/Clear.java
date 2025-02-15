package dev.matias.course.utils;

public class Clear {
    public static void screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Running...!");
    }
}
