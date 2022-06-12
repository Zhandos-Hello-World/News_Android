package com.zhandos.news.feature_news.data.data_source.network.common

import com.google.gson.annotations.SerializedName

enum class Language(val type: String) {
    @SerializedName("ar")
    ARGENTINA("ar"),

    @SerializedName("de")
    GERMANY("de"),

    @SerializedName("es")
    ENGLISH("en"),

    @SerializedName("es")
    SPAIN("es"),

    @SerializedName("fr")
    FRANCE("fr"),

    @SerializedName("is")
    ICELANDIC("is"),

    @SerializedName("it")
    ITALY("it"),

    @SerializedName("nl")
    FLEMISH("nl"),

    @SerializedName("no")
    NORWEGIAN("no"),

    @SerializedName("pt")
    PORTUGUESE("pt"),

    @SerializedName("ru")
    RUSSIAN("ru"),

    @SerializedName("sw")
    SWEDISH("sw"),

    @SerializedName("zh")
    CHINESE("zh")
}