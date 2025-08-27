package dev.nft.apiservice.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nft.apiservice.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(Long userId);
}
