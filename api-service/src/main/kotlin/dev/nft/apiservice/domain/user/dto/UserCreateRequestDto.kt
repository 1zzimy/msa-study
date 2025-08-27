package dev.nft.apiservice.domain.user.dto

import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

@Schema(description = "회원가입 요청 DTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class UserCreateRequestDto(
    @Schema(description = "사용자 이름")
    val username: String,

    @Schema(description = "사용자 이메일")
    val email: String,

    @Schema(description = "사용자 비밀번호")
    val password: String
)