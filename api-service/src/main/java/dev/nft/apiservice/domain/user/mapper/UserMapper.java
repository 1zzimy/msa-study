package dev.nft.apiservice.domain.user.mapper;

import dev.nft.apiservice.domain.user.dto.UserCreateRequestDto;
import dev.nft.apiservice.domain.user.dto.UserInfoResponseDto;
import dev.nft.apiservice.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    /**
     * UserCreateRequestDto를 User 엔티티로 변환
     */
    @Mapping(target = "userId", ignore = true) // ID는 DB에서 생성
    @Mapping(target = "createdAt", ignore = true) // BaseEntity 필드
    @Mapping(target = "updatedAt", ignore = true) // BaseEntity 필드
    User toEntity(UserCreateRequestDto dto);

    /**
     * User 엔티티를 UserInfoResponseDto로 변환
     */
    @Mapping(source = "userId", target = "userId")
    UserInfoResponseDto toResponseDto(User entity);
}
