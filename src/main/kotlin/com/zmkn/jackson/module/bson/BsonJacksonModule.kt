package com.zmkn.jackson.module.bson

import com.fasterxml.jackson.databind.module.SimpleModule
import com.zmkn.jackson.module.bson.serializers.ObjectIdToStringSerializer
import com.zmkn.jackson.module.bson.serializers.StringToObjectIdDeserializer
import org.bson.types.ObjectId

object BsonJacksonModule {
    val objectIdSerializers = fun SimpleModule.() {
        addSerializer(ObjectId::class.java, ObjectIdToStringSerializer())
        addDeserializer(ObjectId::class.java, StringToObjectIdDeserializer())
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
