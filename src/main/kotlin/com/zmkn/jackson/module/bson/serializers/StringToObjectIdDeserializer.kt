package com.zmkn.jackson.module.bson.serializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.bson.types.ObjectId

class StringToObjectIdDeserializer : JsonDeserializer<ObjectId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): ObjectId = ObjectId(p.valueAsString)
}
