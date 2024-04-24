package com.example.cat_api_assessment.data.model

import com.example.cat_api_assessment.data.service.jsonDeserializer.RangeDeserializer
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class Weight(
    @SerializedName("imperial")
    @JsonAdapter(RangeDeserializer::class)
    val imperial: Range,
    @SerializedName("metric")
    @JsonAdapter(RangeDeserializer::class)
    val metric: Range
)
