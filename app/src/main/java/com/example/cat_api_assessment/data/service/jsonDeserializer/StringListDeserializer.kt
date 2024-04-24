package com.example.cat_api_assessment.data.service.jsonDeserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class StringListDeserializer : JsonDeserializer<List<String>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<String> {
        val temperamentString: String = json.asString
        return temperamentString.split(", ").toList()
    }
}