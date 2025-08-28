package dev.nft.core.common.error

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "에러 정보")
data class ErrorInfo(
    @Schema(description = "에러 코드")
    val code: String,

    @Schema(description = "에러 메시지")
    val message: String,

    @Schema(description = "추가 에러 데이터")
    val data: Any? = null
)