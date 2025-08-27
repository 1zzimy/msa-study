package dev.nft.apiservice.domain.user.mapper;

import org.mapstruct.Mapper;

import dev.nft.apiservice.domain.user.dto.UserInfoResponseDto;
import dev.nft.apiservice.domain.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserInfoResponseDto toDto(User user);
}
