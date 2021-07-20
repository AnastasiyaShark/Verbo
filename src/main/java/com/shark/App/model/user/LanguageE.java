package com.shark.App.model.user;

public enum LanguageE {
    ENGLISH ("ENGLISH"),
    SWEDISH ("SWEDISH"),
    RUSSIAN ("RUSSIAN");

    private final String language;

    LanguageE(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
