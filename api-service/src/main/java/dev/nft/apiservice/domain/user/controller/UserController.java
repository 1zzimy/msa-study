package dev.nft.apiservice.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nft.apiservice.domain.user.service.UserService;
import dev.nft.core.common.util.ApiResult;
import dev.nft.apiservice.domain.user.dto.UserCreateRequestDto;
import dev.nft.apiservice.domain.user.dto.UserInfoResponseDto;
import dev.nft.apiservice.domain.user.dto.UserUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "사용자 정보 API")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@Operation(summary = "회원가입")
	public ResponseEntity<?> createUser(UserCreateRequestDto request) {
		userService.register(request);
		return ResponseEntity.ok(ApiResult.success("회원가입 성공"));
	}

	@GetMapping
	@Operation(summary = "회원정보 조회")
	public ResponseEntity<?> getUser(Long userId) {
		UserInfoResponseDto response = userService.getUserInfo(userId);
		return ResponseEntity.ok(ApiResult.success("회원 정보 조회 성공", response));
	}

	@PutMapping
	@Operation(summary = "회원정보 수정")
	public ResponseEntity<?> updateUser(Long userId, UserUpdateRequestDto request) {
		userService.updateUserInfo(userId, request);
		return ResponseEntity.ok(ApiResult.success("회원 정보 수정 성공"));
	}

	@DeleteMapping
	@Operation(summary = "회원탈퇴")
	public ResponseEntity<?> deleteUser(Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok(ApiResult.success("회원 탈퇴 성공"));
	}
}
