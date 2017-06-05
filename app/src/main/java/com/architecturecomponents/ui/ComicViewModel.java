package com.architecturecomponents.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.architecturecomponents.network.models.Comic;
import com.architecturecomponents.repositories.ComicRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Holds Comic LiveData.
 */

public class ComicViewModel extends ViewModel {
    private LiveData<Comic> comic;
    private ComicRepository comicRepository;

    @Inject
    public ComicViewModel(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public void init() {
        if (this.comic != null) {
            return;
        }
        LiveData<List<Comic>> comics = comicRepository.getComics();
    }

    public LiveData<Comic> getComic() {
        return comic;
    }
}
