# DevTogether - 코드 리뷰 플랫폼

> FastCampus Backend Development 13기 수강생들이 개발한 코드 리뷰 및 공유 플랫폼

[![Java](https://img.shields.io/badge/Java-21-orange)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen)](https://spring.io/projects/spring-boot)
[![SvelteKit](https://img.shields.io/badge/SvelteKit-5-ff3e00)](https://kit.svelte.dev/)

개발자들이 코드 스니펫을 공유하고, 게시글을 작성하며, 댓글을 통해 협업할 수 있는 풀스택 웹 애플리케이션입니다.
실시간 Java 코드 하이라이팅과 리치 텍스트 에디터를 제공하여 효과적인 코드 리뷰와 지식 공유를 지원합니다.

## 🚀 주요 기능

- 📝 코드 스니펫 공유 및 Java 문법 하이라이팅
- 💬 실시간 댓글 시스템
- 👤 사용자 인증 및 권한 관리
- 📄 리치 텍스트 에디터 (TipTap)
- 🏷️ 카테고리별 게시글 분류
- 📱 반응형 웹 디자인

## 🛠 기술 스택

### Backend
- **Java 21** with **Spring Boot 3.5.3**
- **Spring Security** - 인증 및 권한 관리
- **Spring Data JPA** - 데이터베이스 ORM
- **H2 Database** (개발) / **MySQL** (프로덕션)
- **Swagger/OpenAPI** - API 문서화
- **Gradle** - 빌드 도구

### Frontend
- **SvelteKit 5** with **TypeScript**
- **TailwindCSS** - 스타일링
- **CodeMirror 6** - Java 코드 에디터
- **TipTap** - 리치 텍스트 에디터
- **Vite** - 빌드 도구

### DevOps
- **Docker** - 컨테이너화
- **H2 Console** - 개발용 데이터베이스 관리

## 📦 프로젝트 구조

```
DevTogether/
├── backend/                    # Spring Boot 백엔드
│   ├── src/main/java/com/BE_13/DevTogether/
│   │   ├── controller/         # REST API 및 MVC 컨트롤러
│   │   ├── service/           # 비즈니스 로직
│   │   ├── entity/            # JPA 엔티티
│   │   ├── dto/               # 요청/응답 객체
│   │   ├── security/          # Spring Security 설정
│   │   └── config/            # 애플리케이션 설정
│   └── src/test/              # 테스트 코드
├── frontend/                   # SvelteKit 프론트엔드
│   ├── src/
│   │   ├── routes/            # 페이지 라우팅
│   │   ├── lib/components/    # 재사용 컴포넌트
│   │   └── stores/            # 상태 관리
│   └── static/                # 정적 파일
└── docker-compose.yml         # Docker 설정
```

## 🚀 개발 환경 설정

### 사전 요구사항
- Java 21+
- Node.js 18+
- Docker (선택사항)

### 1. 저장소 클론
```bash
git clone https://github.com/your-username/DevTogether.git
cd DevTogether
```

### 2. 백엔드 실행
```bash
cd backend
./gradlew bootRun
```
- 서버: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console
- API 문서: http://localhost:8080/swagger-ui.html

### 3. 프론트엔드 실행
```bash
cd frontend
npm install
npm run dev
```
- 개발 서버: http://localhost:5173

### 4. Docker로 실행 (선택사항)
```bash
# 백엔드만 실행
docker-compose up backend

# 전체 빌드 및 실행
docker-compose up --build
```

## 🧪 테스트 실행

### 백엔드 테스트
```bash
cd backend
./gradlew test                                    # 전체 테스트
./gradlew test --tests "ClassName.methodName"    # 특정 테스트
```

### 프론트엔드 타입 체크
```bash
cd frontend
npm run check
```

## 🔧 주요 명령어

### 백엔드
- `./gradlew build` - 프로젝트 빌드
- `./gradlew bootRun` - 애플리케이션 실행
- `./gradlew test` - 테스트 실행

### 프론트엔드
- `npm run dev` - 개발 서버 시작
- `npm run build` - 프로덕션 빌드
- `npm run preview` - 빌드 결과 미리보기

## 📊 데이터베이스 스키마

- **Post**: 게시글 (제목, 내용, 코드 스니펫, 작성자, 권한)
- **Comment**: 댓글 (게시글과 연관관계)
- **User**: 사용자 (역할 기반 권한)
- **Board**: 게시판 카테고리

## 🔐 보안 설정

- Spring Security 기반 인증/인가
- CORS 설정 (Frontend ↔ Backend 통신)
- Role 기반 권한 관리
- 커스텀 인증 실패 핸들러

## 📝 API 문서

개발 서버 실행 후 http://localhost:8080/swagger-ui.html 에서 확인 가능

## 트러블 슈팅
https://healthy-bugle-ea8.notion.site/DevTogether-Trouble-Shooting-239a204e2a29800ea624f81cfe09c7f3?source=copy_link

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👥 팀원

FastCampus Backend Development 13기 수강생들이 개발한 프로젝트입니다.

## 🔗 관련 링크

- [FastCampus Backend Development Course](https://fastcampus.co.kr/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [SvelteKit Documentation](https://kit.svelte.dev/)
