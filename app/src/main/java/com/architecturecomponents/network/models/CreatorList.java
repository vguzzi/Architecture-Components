package com.architecturecomponents.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreatorList {
    @SerializedName("items")
    public List<CreatorSummary> items;
}
