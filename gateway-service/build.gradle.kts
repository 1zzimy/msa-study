plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    // Core Module
    implementation(project(":core"))

    // Kotlin
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Gateway (필수)
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    // WebFlux (필수) - Gateway : Reactor 기반(논블로킹), spring-starter-web 넣으면 충돌 가능성 있어 webflux만 사용
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Eureka Service Client - Discovery (필수)
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // Autuator (healthcheck, monitoring)
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Circuit Breaker (Resilience4j)
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j")

    // Micrometer for metrics
    implementation("io.micrometer:micrometer-registry-prometheus")

    // 기본 로깅 사용 (Log4j2 제거)

    // Spring Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5") // JSON 파서

    // Config Server 연동(중앙 설정 서버 사용 시)
//    implementation("org.springframework.cloud:spring-cloud-starter-config")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}