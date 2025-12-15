package com.zmkn.jackson.module.bson.serializers

import org.bson.types.ObjectId
import tools.jackson.core.JsonParser
import tools.jackson.databind.DatabindException
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.JsonNode
import tools.jackson.databind.ValueDeserializer

class ObjectIdDeserializer : ValueDeserializer<ObjectId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): ObjectId {
        val node = p.objectReadContext().readTree<JsonNode>(p)
        val oid = node.get($$"$oid")?.asString()
            ?: throw DatabindException.from(p, $$"Missing required property '$oid'")
        return ObjectId(oid)
    }
}
