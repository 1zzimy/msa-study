package dev.nft.core.common.error

import dev.nft.core.common.util.logger

class GlobalException(
    val errorType: ErrorType,
    override val message: String = errorType.message
) : RuntimeException(message) {
    private val log = this.logger()
    
    init {
        log.error("GlobalException occurred: ${errorType.code} - $message")
    }
}
