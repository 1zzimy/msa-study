package dev.nft.apiservice.domain.user.dto

import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Getter

@Schema(description = "사용자 정보 응답 DTO")
@Getter
@AllArgsConstructor
data class UserInfoResponseDto(

    @Schema(description = "사용자 이름")
    private var username: String,

    @Schema(description = "사용자 이메일")
    private var email: String
)