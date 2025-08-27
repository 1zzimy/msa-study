package dev.nft.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nft.authservice.common.util.ApiResult;
import dev.nft.authservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Auth", description = "인증 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
	private final AuthService authService;

	@PostMapping("/login")
	@Operation(summary = "로그인")
	public ResponseEntity<?> login() {
		return ResponseEntity.ok(ApiResult.success("로그인 성공"));
	}

	@PostMapping("/reissue")
	@Operation(summary = "토큰 재발급")
	public ResponseEntity<?> reissue() {
		return ResponseEntity.ok(ApiResult.success("토큰 재발급 성공"));
	}

	@PostMapping("/logout")
	@Operation(summary = "로그아웃")
	public ResponseEntity<?> logout() {
		return ResponseEntity.ok(ApiResult.success("로그아웃 성공"));
	}
}
