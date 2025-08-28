package dev.nft.core.common.exception

import dev.nft.core.common.util.ApiResult
import dev.nft.core.common.util.ErrorInfo
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(GlobalException::class)
    fun handleGlobalException(e: GlobalException): ResponseEntity<ApiResult<Void>> {
        log.error("GlobalException: {}", e.message, e)
        val errorInfo = ErrorInfo(e.errorType.code, e.message ?: e.errorType.message, e.data)
        return ResponseEntity
            .status(e.errorType.status)
            .body(ApiResult.error(errorInfo))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(e: MethodArgumentNotValidException): ResponseEntity<ApiResult<Void>> {
        log.error("ValidationException: {}", e.message, e)
        val message = e.bindingResult.fieldErrors.firstOrNull()?.defaultMessage ?: "Validation failed"
        val errorInfo = ErrorInfo(ErrorType.VALIDATION_ERROR.code, message)
        return ResponseEntity
            .status(ErrorType.VALIDATION_ERROR.status)
            .body(ApiResult.error(errorInfo))
    }

    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<ApiResult<Void>> {
        log.error("BindException: {}", e.message, e)
        val message = e.bindingResult.fieldErrors.firstOrNull()?.defaultMessage ?: "Binding failed"
        val errorInfo = ErrorInfo(ErrorType.VALIDATION_ERROR.code, message)
        return ResponseEntity
            .status(ErrorType.VALIDATION_ERROR.status)
            .body(ApiResult.error(errorInfo))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResult<Void>> {
        log.error("UnexpectedException: {}", e.message, e)
        val errorInfo = ErrorInfo(ErrorType.DEFAULT_ERROR.code, ErrorType.DEFAULT_ERROR.message)
        return ResponseEntity
            .status(ErrorType.DEFAULT_ERROR.status)
            .body(ApiResult.error(errorInfo))
    }
}
