package com.architecturecomponents.dagger.component;

import com.architecturecomponents.dagger.module.AppModule;
import com.architecturecomponents.dagger.module.ComicRepositoryModule;
import com.architecturecomponents.dagger.module.MarvelNetModule;
import com.architecturecomponents.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Repository Component, provides all Repository dependencies.
 */

@Singleton
@Component(modules = {AppModule.class, MarvelNetModule.class, ComicRepositoryModule.class})
public interface RepositoryComponent {
    void inject(MainActivity mainActivity);
}
