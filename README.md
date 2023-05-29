# 네모네모로직
## 진행상황
- User
  - User Entity
  - UserController - Service - Repository
    - [x] 유저 정보 조회 API 작성
      - [ ] Test 코드 작성 및 실행 성공
      - [ ] Exception
    - [ ] 유저 수정 API 작성
      - [ ] Test 코드 작성 및 실행 성공
      - [ ] Exception
    - [ ] 유저 수정 API 작성
      - [ ] Test 코드 작성 및 실행 성공
      - [ ] Exception
    - UserResponse
      - [ ] Builder 적용

- Board
- Comment
- Notification
- Reply

## 학습내용
1. @AllArgsConstructor 는 사용하지 않기.
  >클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성하는데, 인스턴스 멤버의 선언 순서에 영향을 받기 때문에 변수의 순서를 바꾸면 생성자의 입력 값 순서도 변경되어 검출되지 않는 치명적인 오류를 유발할 수 있다.
   
그러나, @Builder + @NoArgsConstructor를 사용하기 위해선 @AllArgsConstructor가 필요한데 ?
> @Builder 어노테이션을 클래스가 아닌 생성자에 붙여주면 된다.
