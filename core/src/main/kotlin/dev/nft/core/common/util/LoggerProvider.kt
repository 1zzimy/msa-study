package dev.nft.core.common.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Java와 Kotlin 모두에서 사용할 수 있는 통합 Logger Provider
 * 
 * Java: LoggerProvider.getLogger(Class.class)
 * Kotlin: this.logger()
 */
object LoggerProvider {
    
    /**
     * Java용 static method - 클래스로 Logger 생성
     */
    @JvmStatic
    fun getLogger(clazz: Class<*>): Logger = LoggerFactory.getLogger(clazz)
    
    /**
     * Java용 static method - 클래스명으로 Logger 생성
     */
    @JvmStatic
    fun getLogger(name: String): Logger = LoggerFactory.getLogger(name)
}

/**
 * Kotlin용 extension function
 * 
 * 사용법: private val log = this.logger()
 */
inline fun <reified T : Any> T.logger(): Logger = LoggerFactory.getLogger(T::class.java)
