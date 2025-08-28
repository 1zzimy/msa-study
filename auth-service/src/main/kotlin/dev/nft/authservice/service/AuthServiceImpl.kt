package dev.nft.authservice.service

import dev.nft.core.common.util.logger
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : AuthService {
	private val log = this.logger()
	
	init {
		log.info("AuthService initialized")
	}
}
