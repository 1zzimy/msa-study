package dev.nft.authservice.common.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(description = "기본 API 응답")
public class ApiResult<T> {

	@Schema(description = "응답 메시지")
	private final String message;

	@Schema(description = "응답 데이터")
	private final T data;

	public static <T> ApiResult<T> success(String message, T data) {
		return new ApiResult<>(message, data);
	}

	public static ApiResult<Void> success(String message) {
		return new ApiResult<>(message, null);
	}
}
