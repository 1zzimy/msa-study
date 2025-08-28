package dev.nft.gatewayservice.config

import dev.nft.core.common.util.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController
@RequestMapping("/fallback")
class FallbackController {
    private val log = this.logger()
    
    @GetMapping("/api")
    fun apiFallback(): Mono<ResponseEntity<Map<String, Any>>> {
        log.warn("API Service fallback triggered")
        return Mono.just(
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(
                    mapOf(
                        "timestamp" to LocalDateTime.now(),
                        "message" to "API Service is temporarily unavailable",
                        "fallback" to true
                    )
                )
        )
    }
    
    @GetMapping("/auth")
    fun authFallback(): Mono<ResponseEntity<Map<String, Any>>> {
        log.warn("Auth Service fallback triggered")
        return Mono.just(
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(
                    mapOf(
                        "timestamp" to LocalDateTime.now(),
                        "message" to "Authentication Service is temporarily unavailable",
                        "fallback" to true
                    )
                )
        )
    }
}
