package com.architecturecomponents;

import android.app.Application;

import com.architecturecomponents.dagger.component.DaggerRepositoryComponent;
import com.architecturecomponents.dagger.component.RepositoryComponent;
import com.architecturecomponents.dagger.module.AppModule;
import com.architecturecomponents.dagger.module.ComicRepositoryModule;
import com.architecturecomponents.dagger.module.MarvelNetModule;

public class App extends Application {
    private RepositoryComponent repositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        repositoryComponent = DaggerRepositoryComponent.builder()
            .appModule(new AppModule(this))
            .marvelNetModule(new MarvelNetModule())
            .comicRepositoryModule(new ComicRepositoryModule())
            .build();
    }

    public RepositoryComponent getRepositoryComponent() {
        return repositoryComponent;
    }
}
