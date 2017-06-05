package com.architecturecomponents.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comic {
    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("pageCount")
    public int pageCount;

    @SerializedName("issueNumber")
    public int issueNumber;

    @SerializedName("thumbnail")
    public Image thumbnail;

    @SerializedName("prices")
    public List<ComicPrice> prices;

    @SerializedName("creators")
    public CreatorList creatorList;
}
