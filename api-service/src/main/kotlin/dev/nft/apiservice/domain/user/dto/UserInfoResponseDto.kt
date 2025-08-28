package dev.nft.apiservice.domain.user.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "사용자 정보 응답 DTO")
data class UserInfoResponseDto(
    @Schema(description = "사용자 ID")
    val userId: Long?,
    
    @Schema(description = "사용자 이름")
    val username: String,

    @Schema(description = "사용자 이메일")
    val email: String
)