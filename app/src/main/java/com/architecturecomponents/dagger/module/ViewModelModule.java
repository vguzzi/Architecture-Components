package com.architecturecomponents.dagger.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.architecturecomponents.MarvelViewModelFactory;
import com.architecturecomponents.ui.ComicsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Provides View Models
 */

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ComicsViewModel.class)
    abstract ViewModel bindUserViewModel(ComicsViewModel comicViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(MarvelViewModelFactory factory);
}
