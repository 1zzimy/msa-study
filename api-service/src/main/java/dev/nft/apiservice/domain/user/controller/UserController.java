package dev.nft.apiservice.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nft.apiservice.domain.user.service.UserService;
import dev.nft.core.common.response.ApiResult;
import dev.nft.apiservice.domain.user.dto.UserCreateRequestDto;
import dev.nft.apiservice.domain.user.dto.UserInfoResponseDto;
import dev.nft.apiservice.domain.user.dto.UserUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import dev.nft.core.common.util.LoggerProvider;

@Tag(name = "User", description = "사용자 정보 API")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final org.slf4j.Logger log = LoggerProvider.getLogger(UserController.class);

	@PostMapping
	@Operation(summary = "회원가입")
	public ResponseEntity<?> createUser(UserCreateRequestDto request) {
		log.info("회원가입 API 호출: email={}", request.getEmail());
		userService.register(request);
		log.info("회원가입 API 완료: email={}", request.getEmail());
		return ResponseEntity.ok(ApiResult.success("회원가입 성공"));
	}

	@GetMapping
	@Operation(summary = "회원정보 조회")
	public ResponseEntity<?> getUser(Long userId) {
		log.info("회원정보 조회 API 호출: userId={}", userId);
		UserInfoResponseDto response = userService.getUserInfo(userId);
		log.info("회원정보 조회 API 완료: userId={}", userId);
		return ResponseEntity.ok(ApiResult.success(response));
	}

	@PutMapping
	@Operation(summary = "회원정보 수정")
	public ResponseEntity<?> updateUser(Long userId, UserUpdateRequestDto request) {
		log.info("회원정보 수정 API 호출: userId={}, username={}", userId, request.getUsername());
		userService.updateUserInfo(userId, request);
		log.info("회원정보 수정 API 완료: userId={}", userId);
		return ResponseEntity.ok(ApiResult.success("회원 정보 수정 성공"));
	}

	@DeleteMapping
	@Operation(summary = "회원탈퇴")
	public ResponseEntity<?> deleteUser(Long userId) {
		log.info("회원탈퇴 API 호출: userId={}", userId);
		userService.deleteUser(userId);
		log.info("회원탈퇴 API 완료: userId={}", userId);
		return ResponseEntity.ok(ApiResult.success("회원 탈퇴 성공"));
	}
}
