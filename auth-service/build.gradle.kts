plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    java
}

dependencies {
    // Core Module
    implementation(project(":core"))
    
    // Kotlin
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    
    // Spring Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // Validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // OAuth2
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")

    // Kotlin 기능 활용 (Lombok 제거)

    // Swegger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // Eureka Service Client - Discovery
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // Autuator (healthcheck, monitoring)
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // 기본 로깅 사용 (Log4j2 제거)

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}