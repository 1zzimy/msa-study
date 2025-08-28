package dev.nft.apiservice.domain.user.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "사용자 정보 수정 요청 DTO")
data class UserUpdateRequestDto(

    @Schema(description = "사용자 이름")
    val username: String
)
