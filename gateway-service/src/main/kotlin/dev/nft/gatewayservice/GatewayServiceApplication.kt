package dev.nft.gatewayservice

import dev.nft.core.common.util.logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication(
    scanBasePackages = [ "dev.nft" ]               // 전역 스캔
)
@EnableDiscoveryClient
class GatewayServiceApplication {
    private val log = this.logger()
    
    init {
        log.info("GatewayService initialized")
    }
}

fun main(args: Array<String>) {
    runApplication<GatewayServiceApplication>(*args)
}
