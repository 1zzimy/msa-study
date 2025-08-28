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
}
