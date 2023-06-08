# 네모네모로직
## 진행상황
- User
  - User Entity
  - UserController - Service - Repository
    - [x] 유저 회원 가입 API 작성
      - [x] AuthController로 역할 분리하기
      - [ ] 유효성 검사
        - [x] nickname 중복검사
          > Service에서 따로 매소드로 분류
      - [x] Test 코드 작성 및 실행 성공
    - [x] 유저 정보 조회 API 작성
      - [x] Test 코드 작성 및 실행 성공
      - [ ] Exception
        - Custom Exception 생성하기
          - 중복체크 등
      - [ ] 유저 수정 API 작성
        - [ ] Test 코드 작성 및 실행 성공
        - [ ] Exception
      - UserResponse
        - [ ] Builder 적용

- Board
  - [ ] 페이징 : QueryDSL 사용하기
    > 정렬이나, 검색 조건들이 추가됐을 때 편함.
- Comment
- Notification
- Reply

## 학습내용
1. @AllArgsConstructor 는 사용하지 않기.
  >클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성하는데, 인스턴스 멤버의 선언 순서에 영향을 받기 때문에 변수의 순서를 바꾸면 생성자의 입력 값 순서도 변경되어 검출되지 않는 치명적인 오류를 유발할 수 있다.
   
그러나, @Builder + @NoArgsConstructor를 사용하기 위해선 @AllArgsConstructor가 필요한데 ?
> @Builder 어노테이션을 클래스가 아닌 생성자에 붙여주면 해결된다.

2. ModelMapper를 사용하면 User를 UserResponse로 쉽게 매핑할 수 있다.
3. @EnableJpaAuditing를 Application 위에 추가해줘야 스프링부트가 JPA Auditing을 활성화한다.
  > Postman으로 회원가입을 해도 생성날짜가 null 값으로 들어갔었다. @EnableJpaAuditing을 추가하여 해결했다.

4. Test 작성 시 @BeforeEach를 활용하여 중복 코드들을 제거. 
   - @BeforeEach - 테스트마다 초기 상태로 만들기 위해 사용
   - @AfterEach - 테스트가 끝나고 원상복귀를 위해 사용

5. spring-boot-starter-test 라이브러리는 junit5를 제공한다.
   - Test클래스 및 매소드에 public을 필수로 작성하지 않아도 된다.
