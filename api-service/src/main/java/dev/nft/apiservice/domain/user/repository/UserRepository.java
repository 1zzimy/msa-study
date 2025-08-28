package dev.nft.apiservice.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.nft.apiservice.domain.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(Long userId);
}
