rootProject.name = "msa-study"
include(
    // 서브 모듈
    "core",

    // 서버
    "gateway-service",
    "discovery-service",
    "auth-service",
    "api-service"
)