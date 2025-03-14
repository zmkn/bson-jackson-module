package com.zmkn.jackson.module.bson.serializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.JsonNode
import org.bson.types.ObjectId

class ObjectIdDeserializer : JsonDeserializer<ObjectId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): ObjectId {
        val node = p.codec.readTree<JsonNode>(p)
        val oid = node.get("\$oid")?.asText()
            ?: throw JsonMappingException(p, "Missing required property '\$oid'")
        return ObjectId(oid)
    }
}
