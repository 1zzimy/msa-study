plugins {
    id("org.springframework.boot") version "3.5.5" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    java
}

extra["springCloudVersion"] = "2025.0.0"

allprojects {
    group = "dev.nft"
    version = "1.0-SNAPSHOT"
    repositories { mavenCentral() }
}

subprojects {
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java")

    java { toolchain { languageVersion.set(JavaLanguageVersion.of(21)) } }

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            val v = rootProject.extra["springCloudVersion"] as String
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:$v")
        }
    }

    tasks.withType<Test> { useJUnitPlatform() }
}