# MSA Project Structure

본 프로젝트는 MSA(Microservice Architecture) 기반으로 설계되었으며, 각 서비스는 독립적으로 배포/운영될 수 있습니다.

또한 공통 모듈은 재사용성을 위해 별도 서브 모듈로 분리되어 있습니다.

## 🗂️ Modules

### api-service

- 도메인 중심의 REST API 서버
- 디렉토리 구조: Java(Controller/Service/Repository) + Kotlin(DTO/Entity) 혼용
- 인증은 `gateway-service`에서 1차 처리된 토큰을 이용해 인가 중심으로 검증

### auth-service

- 인증/인가 담당
- 로그인, 토큰 발급/재발급, 로그아웃 등 사용자 인증 관련 기능 제공
- JWT/세션/쿠키 기반 인증 로직 포함
- OAuth2 소셜 로그인 연동

### discovery-service

- 서비스 등록 및 탐색 담당
- 각 마이크로서비스의 위치(IP/Port)를 관리하여 통신 안정화
- Netflix Eureka 기반으로 구현

### gateway-service

- 외부 트래픽 단일 진입점 (API Gateway)
- 라우팅, CORS, 인증 필터, 공통 로깅 헤더 삽입
- 외부 트래픽을 각 서비스로 분산

### core

- 공통적으로 사용되는 도메인 객체, 유틸리티, 공통 설정을 모아둔 서브 모듈
- 다른 모듈에서 dependency로 가져와 재사용

### db

- 각 서비스가 참조할 수 있는 DB 설정을 담당하는 서브 모듈
- 데이터베이스 관련 설정 및 마이그레이션(Flyway) 관리

### support

- 부가적인 기능을 담당하는 서브 모듈
- 각 서비스에서 공통적으로 필요한 로깅, 모니터링 설정을 제공
