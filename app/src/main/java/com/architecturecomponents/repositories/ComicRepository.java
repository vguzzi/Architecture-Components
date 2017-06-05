package com.architecturecomponents.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.architecturecomponents.network.MarvelWebService;
import com.architecturecomponents.network.StaticKeys;
import com.architecturecomponents.network.models.Comic;
import com.architecturecomponents.network.models.responses.GetComicsResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ComicRepository used for querying comics.
 */

@Singleton
public class ComicRepository {
    private final MarvelWebService marvelWebService;
    private final StaticKeys staticKeys;

    @Inject
    public ComicRepository(MarvelWebService marvelWebService, StaticKeys staticKeys) {
        this.marvelWebService = marvelWebService;
        this.staticKeys = staticKeys;
    }

    public LiveData<List<Comic>> getComics() {
        final MutableLiveData<List<Comic>> data = new MutableLiveData<>();

        String timeStamp = String.valueOf(System.currentTimeMillis());
        marvelWebService.getComics(timeStamp, staticKeys.getApiKey(), staticKeys.getHash(timeStamp), null, null, null)
            .enqueue(new Callback<GetComicsResponse>() {
                @Override
                public void onResponse(Call<GetComicsResponse> call, Response<GetComicsResponse> response) {
                    GetComicsResponse getComicsResponse = response.body();
                    if (getComicsResponse != null) {
                        data.setValue(getComicsResponse.comicDataContainer.results);
                    }
                }

                @Override
                public void onFailure(Call<GetComicsResponse> call, Throwable t) {
                    // to be implemented when persistent data is added
                    Log.d("ComicRepository", "API call failure.");
                }
            });
        return data;
    }
}
