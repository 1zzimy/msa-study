package dev.nft.apiservice.domain.user.service;

import dev.nft.apiservice.domain.user.dto.UserCreateRequestDto;
import dev.nft.apiservice.domain.user.dto.UserInfoResponseDto;
import dev.nft.apiservice.domain.user.dto.UserUpdateRequestDto;

public interface UserService {
	void register(UserCreateRequestDto request);

	UserInfoResponseDto getUserInfo(Long userId);

	void updateUserInfo(Long userId, UserUpdateRequestDto request);

	void deleteUser(Long userId);
}
