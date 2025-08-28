package dev.nft.gatewayservice.config

import dev.nft.core.common.util.logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {
    private val log = this.logger()
    
    init {
        log.info("SecurityConfig initialized")
    }

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .csrf { it.disable() } // CSRF 비활성화 (API Gateway에서는 일반적)
            .authorizeExchange { exchanges ->
                exchanges
                    // Actuator 엔드포인트 허용
                    .pathMatchers("/actuator/**").permitAll()
                    // 폴백 엔드포인트 허용
                    .pathMatchers("/fallback/**").permitAll()
                    // 헬스체크 허용
                    .pathMatchers("/health").permitAll()
                    // 테스트를 위해 임시로 모든 요청 허용
                    .anyExchange().permitAll()
            }
            .build()
    }
}
