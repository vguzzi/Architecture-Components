package com.architecturecomponents.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.architecturecomponents.network.models.Comic;
import com.architecturecomponents.repositories.ComicRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Holds Comic list LiveData.
 */

public class ComicsViewModel extends ViewModel {
    private LiveData<List<Comic>> comics;
    private ComicRepository comicRepository;

    @Inject
    public ComicsViewModel(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public void init() {
        if (this.comics != null) {
            return;
        }
        comics = comicRepository.getComics();
    }

    public LiveData<List<Comic>> getComics() {
        return comics;
    }
}

