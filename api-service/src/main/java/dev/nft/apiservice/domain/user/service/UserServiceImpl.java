package dev.nft.apiservice.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.nft.apiservice.domain.user.dto.UserInfoResponseDto;
import dev.nft.apiservice.domain.user.dto.UserUpdateRequestDto;
import dev.nft.apiservice.domain.user.entity.User;
import dev.nft.apiservice.domain.user.mapper.UserMapper;
import dev.nft.apiservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	// 회원 가입

	// 회원 정보 조회
	public UserInfoResponseDto getUserInfo(Long userId) {
		User user = userRepository.findByUserId(userId);
		return userMapper.toDto(user);
	}

	// 회원 정보 수정
	@Transactional
	public void updateUserInfo(Long userId, UserUpdateRequestDto request) {
		User user = userRepository.findByUserId(userId);
		user.update(request.getUsername());
	}

	// 회원 탈퇴
	public void deleteUser(Long userId) {
		// 소프트 삭제 + 탈퇴 사용자 정보 관리 DB에 옮기기
	}
}
