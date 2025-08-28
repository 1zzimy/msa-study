package dev.nft.core.common.response

import dev.nft.core.common.error.ErrorInfo
import org.springframework.http.ResponseEntity

/**
 * ResponseEntity 확장 함수들
 */

/**
 * 성공 응답을 ResponseEntity로 변환
 */
fun <T> ApiResult<T>.toResponseEntity(): ResponseEntity<ApiResult<T>> {
    return ResponseEntity.ok(this)
}

/**
 * 성공 응답을 ResponseEntity로 변환 (상태 코드 지정)
 */
fun <T> ApiResult<T>.toResponseEntity(status: org.springframework.http.HttpStatus): ResponseEntity<ApiResult<T>> {
    return ResponseEntity.status(status).body(this)
}

/**
 * 데이터를 성공 응답으로 변환
 */
fun <T> T.toSuccessResponse(): ResponseEntity<ApiResult<T>> {
    return ApiResult.success(this).toResponseEntity()
}

/**
 * 메시지를 성공 응답으로 변환
 */
fun String.toSuccessResponse(): ResponseEntity<ApiResult<Void>> {
    return ApiResult.success(this).toResponseEntity()
}

/**
 * 에러 정보를 에러 응답으로 변환
 */
fun ErrorInfo.toErrorResponse(): ResponseEntity<ApiResult<Void>> {
    return ApiResult.error<Void>(this).toResponseEntity()
}