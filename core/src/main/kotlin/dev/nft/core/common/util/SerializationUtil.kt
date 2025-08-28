package dev.nft.core.common.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Component

@Component
class SerializationUtil(private val objectMapper: ObjectMapper) {

    /**
     * 객체를 JSON 문자열로 직렬화
     */
    fun <T> toJson(obj: T): String {
        return objectMapper.writeValueAsString(obj)
    }

    /**
     * JSON 문자열을 객체로 역직렬화
     */
    fun <T> fromJson(json: String, clazz: Class<T>): T {
        return objectMapper.readValue(json, clazz)
    }

    /**
     * 객체를 다른 타입으로 변환
     */
    fun <T> convert(obj: Any, clazz: Class<T>): T {
        val json = objectMapper.writeValueAsString(obj)
        return objectMapper.readValue(json, clazz)
    }
}
