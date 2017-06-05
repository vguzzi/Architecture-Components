package com.architecturecomponents.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicDataContainer {
    @SerializedName("count")
    public int count;

    @SerializedName("offset")
    public int offset;

    @SerializedName("results")
    public List<Comic> results;
}
