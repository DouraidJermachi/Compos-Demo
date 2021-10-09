package com.douraid.composedemo.api.studies.mapper

import com.douraid.composedemo.api.dto.BodyElementResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object BodyElementResponseMapper {

    @FromJson
    fun fromJson(
        reader: JsonReader,
        delegate: JsonAdapter<BodyElementResponse.ImageBodyElementResponse>
    ): BodyElementResponse {

        val jsonValue = reader.readJsonValue()

        return try {
            when (jsonValue) {
                is String -> BodyElementResponse.TextBodyElementResponse(jsonValue)
                else -> delegate.fromJsonValue(jsonValue)
                    ?: throw JsonDataException("cannot convert body element of: $jsonValue")
            }
        } catch (throwable: Throwable) {
            throw JsonDataException("cannot convert body element of: $jsonValue")
        }
    }

    @Suppress("UNUSED_PARAMETER", "unused")
    @ToJson
    fun toJson(writer: JsonWriter, value: BodyElementResponse?) {
        throw UnsupportedOperationException()
    }
}