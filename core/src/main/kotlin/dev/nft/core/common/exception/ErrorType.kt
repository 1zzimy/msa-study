package dev.nft.core.common.exception

import org.springframework.http.HttpStatus

enum class ErrorType(
    @JvmField
    val status: HttpStatus,
    @JvmField
    val code: String,
    @JvmField
    val message: String
) {
    // 일반 에러
    DEFAULT_ERROR(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "E500",
        "내부 서버 오류가 발생했습니다."
    ),
    VALIDATION_ERROR(
        HttpStatus.BAD_REQUEST,
        "E400",
        "입력 데이터가 올바르지 않습니다."
    ),
    UNAUTHORIZED_ERROR(
        HttpStatus.UNAUTHORIZED,
        "E401",
        "인증이 필요합니다."
    ),
    FORBIDDEN_ERROR(
        HttpStatus.FORBIDDEN,
        "E403",
        "접근 권한이 없습니다."
    ),
    NOT_FOUND_ERROR(
        HttpStatus.NOT_FOUND,
        "E404",
        "요청한 리소스를 찾을 수 없습니다."
    ),

    // 비즈니스 에러
    USER_NOT_FOUND(
        HttpStatus.NOT_FOUND,
        "E1001",
        "사용자를 찾을 수 없습니다."
    ),
    USER_ALREADY_EXISTS(
        HttpStatus.CONFLICT,
        "E1002",
        "이미 존재하는 사용자입니다."
    ),
    INVALID_PASSWORD(
        HttpStatus.BAD_REQUEST,
        "E1003",
        "비밀번호가 올바르지 않습니다."
    ),
    TOKEN_EXPIRED(
        HttpStatus.UNAUTHORIZED,
        "E1004",
        "토큰이 만료되었습니다."
    ),
    INVALID_TOKEN(
        HttpStatus.UNAUTHORIZED,
        "E1005",
        "유효하지 않은 토큰입니다."
    );
}
