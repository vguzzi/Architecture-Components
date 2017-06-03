package com.architecturecomponents.network;

import com.architecturecomponents.network.models.GetComicsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Web Service for connecting to the Marvel API.
 */

public interface MarvelWebService {
    @GET("/v1/public/comics")
    Call<GetComicsResponse> getComics(
        @Query("apiKey") String apiKey,
        @Query("dateDescriptor") String dateDescriptor,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith);
}
