package com.architecturecomponents.dagger.module;

import com.architecturecomponents.network.MarvelWebService;
import com.architecturecomponents.network.StaticKeys;
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
    ComicRepository provideComicRepository(MarvelWebService marvelWebService, StaticKeys staticKeys) {
        return new ComicRepository(marvelWebService, staticKeys);
    }
}
