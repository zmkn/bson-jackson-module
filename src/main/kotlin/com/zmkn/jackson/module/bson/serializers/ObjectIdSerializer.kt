package com.zmkn.jackson.module.bson.serializers

import org.bson.types.ObjectId
import tools.jackson.core.JsonGenerator
import tools.jackson.databind.SerializationContext
import tools.jackson.databind.ValueSerializer

class ObjectIdSerializer : ValueSerializer<ObjectId>() {
    override fun serialize(value: ObjectId, gen: JsonGenerator, ctxt: SerializationContext) {
        gen.writeStartObject()
        gen.writeStringProperty($$"$oid", value.toHexString())
        gen.writeEndObject()
    }
}
