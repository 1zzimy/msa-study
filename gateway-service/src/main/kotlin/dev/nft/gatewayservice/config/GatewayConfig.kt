package dev.nft.gatewayservice.config

import dev.nft.core.common.util.logger
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@Configuration
class GatewayConfig {
    private val log = this.logger()
    
    init {
        log.info("GatewayConfig initialized with timeout, circuit breaker, and retry policies")
    }

    @Bean
    fun routeLocator(builder: RouteLocatorBuilder): RouteLocator =
        builder.routes()
            .route("api_route") { it
                .path("/api/v1/user/**")
                .filters { f -> f
                    .rewritePath("/api/v1/user/(?<segment>.*)", "/\${segment}")
                    .addRequestHeader("X-Gateway-Service", "gateway-service")
                    .addRequestHeader("X-Response-Time", System.currentTimeMillis().toString())
                    // Circuit Breaker 설정
                    .circuitBreaker { cb -> 
                        cb.setName("api-service")
                          .setFallbackUri("forward:/fallback/api")
                    }
                    // 재시도 정책 (올바른 문법)
                    .retry { config ->
                        config.setRetries(2)
                            .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.SERVICE_UNAVAILABLE)
                            .setMethods(HttpMethod.GET, HttpMethod.POST)
                            .setBackoff(Duration.ofMillis(100), Duration.ofSeconds(2), 2, true)
                    }
                    // 타임아웃 설정
                    .setResponseHeader("X-Response-Timeout", "3000ms")
                }
                .uri("lb://api-service")
            }
            .route("auth_route") { it
                .path("/api/v1/auth/**")
                .filters { f -> f
                    .rewritePath("/api/v1/auth/(?<segment>.*)", "/\${segment}")
                    .addRequestHeader("X-Gateway-Service", "gateway-service")
                    // Circuit Breaker 설정
                    .circuitBreaker { cb -> 
                        cb.setName("auth-service")
                          .setFallbackUri("forward:/fallback/auth")
                    }
                    // 재시도 정책 (인증은 재시도 제한)
                    .retry { config ->
                        config.setRetries(1)
                            .setStatuses(HttpStatus.SERVICE_UNAVAILABLE)
                            .setMethods(HttpMethod.POST)
                    }
                    // 타임아웃 설정
                    .setResponseHeader("X-Response-Timeout", "2000ms")
                }
                .uri("lb://auth-service")
            }
            .build()
}
