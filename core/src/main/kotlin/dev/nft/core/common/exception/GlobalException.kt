package dev.nft.core.common.exception

class GlobalException @JvmOverloads constructor(
    val errorType: ErrorType,
    val data: Any? = null,
    override val message: String = errorType.message
) : RuntimeException(message) {
    
    constructor(errorType: ErrorType, cause: Throwable) : 
        this(errorType, message = errorType.message) {
        this.initCause(cause)
    }
}
