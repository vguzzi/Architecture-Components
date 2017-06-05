package com.architecturecomponents.network.models.responses;

import com.architecturecomponents.network.models.ComicDataContainer;
import com.google.gson.annotations.SerializedName;

/**
 * GetComicsResponse response object returned from:
 * {@link com.architecturecomponents.network.MarvelWebService #getComics}
 */

public class GetComicsResponse {
    @SerializedName("data")
    public ComicDataContainer comicDataContainer;
}
