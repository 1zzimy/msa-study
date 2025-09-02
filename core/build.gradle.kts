plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring Framework
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-context")

    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // Jackson Core
    implementation("com.fasterxml.jackson.core:jackson-databind")

    // Kotlin 지원
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Java Time (LocalDate, LocalDateTime 직렬화 지원)
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
}
