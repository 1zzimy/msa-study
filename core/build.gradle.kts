plugins {
    java
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.spring") version "2.0.20"
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring Framework
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-context")

    // Jackson Kotlin Module (직렬화/역직렬화)
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
