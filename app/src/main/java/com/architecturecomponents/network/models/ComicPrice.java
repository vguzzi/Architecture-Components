package com.architecturecomponents.network.models;

import com.google.gson.annotations.SerializedName;

public class ComicPrice {
    @SerializedName("type")
    public String type;

    @SerializedName("price")
    public float price;
}
