package com.architecturecomponents.repositories;

import com.architecturecomponents.network.MarvelWebService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * GetComicsResponse book repository used for querying comics.
 */

@Singleton
public class ComicRepository {
    private final MarvelWebService marvelWebService;

    @Inject
    public ComicRepository(MarvelWebService marvelWebService) {
        this.marvelWebService = marvelWebService;
    }
}
