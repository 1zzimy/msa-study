plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
}

dependencies {
    // Gateway (필수)
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    // WebFlux (필수) - Gateway : Reactor 기반(논블로킹), spring-starter-web 넣으면 충돌 가능성 있어 webflux만 사용
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Eureka Service Client - Discovery (필수)
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // Autuator (healthcheck, monitoring)
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Logging - Log4j2
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

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