plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm") version "2.0.20" // Kotlin 지원
    kotlin("plugin.spring") version "2.0.20" // Spring 과 Kotlin 통합
    kotlin("plugin.jpa") version "2.0.20" // JPA no-arg 생성자
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

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // DB
    runtimeOnly("com.mysql:mysql-connector-j")

    // Lombok (Java에서만 사용)
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Swegger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // Eureka Service Client - Discovery
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // Actuator (healthcheck, monitoring)
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Logging - Log4j2 (기본 로깅 제외)
    implementation("org.springframework.boot:spring-boot-starter-log4j2") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    
    // 기본 로깅 제외
    configurations.all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    
    // MapStruct (Java에서만 사용하므로 annotationProcessor만)
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
