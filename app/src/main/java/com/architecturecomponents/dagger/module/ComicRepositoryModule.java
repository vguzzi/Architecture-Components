package com.architecturecomponents.dagger.module;

import com.architecturecomponents.network.MarvelWebService;
import com.architecturecomponents.repositories.ComicRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides GetComicsResponse book repository.
 */

@Module
public class ComicRepositoryModule {
    @Provides
    @Singleton
    ComicRepository provideComicRepository(MarvelWebService marvelWebService) {
        return new ComicRepository(marvelWebService);
    }
}
