package com.zmkn.jackson.module.bson

import com.fasterxml.jackson.databind.module.SimpleModule
import com.zmkn.jackson.module.bson.serializers.ObjectIdSerializer
import com.zmkn.jackson.module.bson.serializers.ObjectIdDeserializer
import org.bson.types.ObjectId

object BsonJacksonModule {
    val objectIdSerializers = fun SimpleModule.() {
        addSerializer(ObjectId::class.java, ObjectIdSerializer())
        addDeserializer(ObjectId::class.java, ObjectIdDeserializer())
    }

    val all: SimpleModule by lazy {
        generateModule(
            objectIdSerializers,
        )
    }

    fun generateModule(vararg serializers: SimpleModule.() -> Unit): SimpleModule {
        return SimpleModule().apply {
            serializers.forEach {
                it()
            }
        }
    }
}
