package dev.nft.gatewayservice.config

import dev.nft.core.common.util.logger
import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.time.Duration
import java.util.concurrent.TimeUnit

@Configuration
class WebClientConfig {
    private val log = this.logger()
    
    init {
        log.info("WebClientConfig initialized with timeout settings")
    }

    @Bean
    fun webClient(builder: WebClient.Builder): WebClient =
        builder.clientConnector(
            ReactorClientHttpConnector(
                HttpClient.create()
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000) // 연결 타임아웃 1초
                    .responseTimeout(Duration.ofSeconds(3)) // 응답 타임아웃 3초
                    .doOnConnected { conn ->
                        conn.addHandlerLast(ReadTimeoutHandler(3, TimeUnit.SECONDS)) // 읽기 타임아웃
                        conn.addHandlerLast(WriteTimeoutHandler(3, TimeUnit.SECONDS)) // 쓰기 타임아웃
                    }
            )
        ).build()
}
