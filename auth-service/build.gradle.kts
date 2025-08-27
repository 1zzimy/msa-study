plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
}

dependencies {
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

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // Swegger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // Eureka Service Client - Discovery
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // Autuator (healthcheck, monitoring)
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Logging - Log4j2
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}