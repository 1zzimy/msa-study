package dev.nft.gatewayservice.config

import dev.nft.core.common.util.logger
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.Ordered
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class GlobalFilter : GlobalFilter, Ordered {
    private val log = this.logger()
    
    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        val request: ServerHttpRequest = exchange.request
        val path = request.path.value()
        val method = request.method?.toString() ?: "UNKNOWN"
        
        log.info("Global Filter - Request: $method $path")
        
        // 요청 시작 시간 기록
        exchange.attributes["startTime"] = System.currentTimeMillis()
        
        return chain.filter(exchange)
            .doFinally {
                val endTime = System.currentTimeMillis()
                val startTime = exchange.attributes["startTime"] as? Long ?: endTime
                val duration = endTime - startTime
                
                log.info("Global Filter - Response: $method $path - Duration: ${duration}ms")
            }
    }
    
    override fun getOrder(): Int = Ordered.HIGHEST_PRECEDENCE
}
