package dev.nft.core.common.response

import dev.nft.core.common.error.ErrorInfo
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "기본 API 응답")
data class ApiResult<T> private constructor(
    @Schema(description = "응답 결과")
    val result: ResultType,

    @Schema(description = "응답 데이터")
    val data: T? = null,

    @Schema(description = "에러 정보")
    val error: ErrorInfo? = null
) {
    companion object {
        // 성공 응답 팩토리 메서드
        @JvmStatic
        fun <T> success(data: T): ApiResult<T> = ApiResult(ResultType.SUCCESS, data = data)

        @JvmStatic
        fun <T> success(message: String, data: T): ApiResult<T> = ApiResult(ResultType.SUCCESS, data = data)

        @JvmStatic
        fun success(): ApiResult<Void> = ApiResult(ResultType.SUCCESS)

        @JvmStatic
        fun success(message: String): ApiResult<Void> = ApiResult(ResultType.SUCCESS)

        // 에러 응답 팩토리 메서드
        @JvmStatic
        fun <T> error(error: ErrorInfo): ApiResult<T> = ApiResult(ResultType.ERROR, error = error)

        @JvmStatic
        fun error(code: String, message: String): ApiResult<Void> =
            ApiResult(ResultType.ERROR, error = ErrorInfo(code, message, null))

        @JvmStatic
        fun error(message: String): ApiResult<Void> =
            ApiResult(ResultType.ERROR, error = ErrorInfo("ERROR", message, null))
    }
}