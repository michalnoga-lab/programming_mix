package com.app.tools;

import java.nio.file.Paths;

public class PathsHandler {

    private static final String SYSTEM_PATH = System.getProperty("user.dir") + System.getProperty("file.separator");

    public static String getWordsPath() {
        return SYSTEM_PATH + Paths.get("src", "main", "resources", "files", "Words.txt");
    }

    public static String getScoresPath() {
        return SYSTEM_PATH + Paths.get("src", "main", "resources", "files", "Scores.txt");
    }
}
