package com.example.cat_api_assessment.data.service.jsonDeserializer

import com.example.cat_api_assessment.data.model.Range
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class RangeDeserializer : JsonDeserializer<Range> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Range {
        val rangeString: String = json.asString
        val rangeValues: List<String> = rangeString.split(" - ")

        val min: Int = try {
            rangeValues[0].toInt()
        } catch (e: NumberFormatException) {
            throw JsonParseException("Invalid min value in range: $rangeString")
        }

        val max: Int = try {
            rangeValues[1].toInt()
        } catch (e: NumberFormatException) {
            throw JsonParseException("Invalid max value in range: $rangeString")
        }

        return Range(min, max)
    }
}