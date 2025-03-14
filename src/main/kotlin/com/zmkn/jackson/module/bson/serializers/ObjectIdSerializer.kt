package com.zmkn.jackson.module.bson.serializers

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.bson.types.ObjectId

class ObjectIdSerializer : JsonSerializer<ObjectId>() {
    override fun serialize(value: ObjectId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        gen.writeStringField("\$oid", value.toHexString())
        gen.writeEndObject()
    }
}
