package dev.nft.apiservice.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.nft.apiservice.domain.user.dto.UserCreateRequestDto;
import dev.nft.apiservice.domain.user.dto.UserInfoResponseDto;
import dev.nft.apiservice.domain.user.dto.UserUpdateRequestDto;
import dev.nft.apiservice.domain.user.entity.User;
import dev.nft.apiservice.domain.user.mapper.UserMapper;
import dev.nft.apiservice.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import dev.nft.core.common.util.LoggerProvider;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final org.slf4j.Logger log = LoggerProvider.getLogger(UserServiceImpl.class);

	// 회원 가입
	public void register(UserCreateRequestDto request) {
		log.info("회원가입 요청: {}", request.getEmail());
		User user = userMapper.toEntity(request);
		userRepository.save(user);
		log.info("회원가입 완료: userId={}", user.getUserId());
	}

	// 회원 정보 조회
	public UserInfoResponseDto getUserInfo(Long userId) {
		log.info("회원 정보 조회: userId={}", userId);
		User user = userRepository.findByUserId(userId);
		log.info("회원 정보 조회 완료: userId={}, email={}", userId, user.getEmail());
		return userMapper.toResponseDto(user);
	}

	// 회원 정보 수정
	@Transactional
	public void updateUserInfo(Long userId, UserUpdateRequestDto request) {
		log.info("회원 정보 수정: userId={}, username={}", userId, request.getUsername());
		User user = userRepository.findByUserId(userId);
		user.update(request.getUsername());
		log.info("회원 정보 수정 완료: userId={}", userId);
	}

	// 회원 탈퇴
	public void deleteUser(Long userId) {
		log.info("회원 탈퇴: userId={}", userId);
		User user = userRepository.findByUserId(userId);
		userRepository.delete(user);
		log.info("회원 탈퇴 완료: userId={}", userId);
		// 소프트 삭제 + 탈퇴 사용자 정보 관리 DB에 옮기기
	}
}
