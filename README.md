# 🚀미션 - 다리 건너기

## 진행방식

- 미션은 기능 요구 사항, 프로그래밍 요구 사항, 과제 요구 사항 세가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다.

---

### 💙구현 목표

- 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

### 📜구현 동작

1. 게임 시작 문구를 출력한다.
2. 다리의 길이를 숫자로 입력 받고 생성한다.
3. 다리가 생성되면 플레이어가 이동할 칸을 선택한다. (위: U, 아래: D)
4. 다리를 끝까지 건너면 게임이 종료된다. 5
5. 다리를 건너다 실패하면 게임을 재시작하거나 종료 여부를 입력 받는다(재시작: R, 종료: Q)
6. 게임 종료 문구를 출력한다.

---

## 🔍구현 로직

- ### Main diagram

- [ ] Application
- [ ] BridgeGame
- [ ] BridgeMaker
- [ ] BridgeNumberGenerator
- [ ] BridgeRandomNumberGenerator


- ### Util diagram
- [ ] Validate


- ### View diagram
- [ ] InputView
- [ ] OutputView


---

## ✅기능 목록 checkList

- [x] 1.게임 시작 문구 출력한다.
- [x] 2.자동으로 생성할 다리의 길이를 입력 받는다.
  - [x] 생성한 다리 리스트를 가진 객체를 생성한다.
- [x] 3.이동할 칸을 선택한다. (위: U, 아래: D)
  - [x] 이동한 칸에 대한 결과를 출력한다. 
- [x] 4.다리를 끝까지 건너면 게임이 종료된다.
- [x] 5.다리를 건너다 실패하면 게임을 재시작하거나 종료 여부를 입력 받는다(재시작: R, 종료: Q)
  - [x] 게임을 다시 시도할지 여부를 입력 받는다.
- [x] 게임 종료 문구를 출력한다.
  - [x] 게임을 성공했으면 성공, 실패했으면 실패가 출력된다.
  - [x] 총 시도한 횟수를 출력한다.


## ✅추가할 객체


## ✅예외 처리

- [x] 자동으로 생성할 다리의 길이를 입력 받는다. -> 예외 처리
  - [x] 3미만 혹은 20 초과의 숫자를 입력한 경우
  - [x] 숫자가 아닌 문자를 입력한 경우
- [x] 이동할 칸을 선택한다. (위: U, 아래: D) -> 예외 처리
  - [x] U 또는 D가 아닌 다른 문자를 입력한 경우
  - [x] U 또는 D가 아닌 숫자를 입력한 경우
- [x] 다리를 건너다 실패하면 게임을 재시작하거나 종료 여부를 입력 받는다 (재시작: R, 종료: Q) -> 예외 처리
  - [x] R 또는 Q가 아닌 다른 문자를 입력한 경우
  - [x] R 또는 Q가 아닌 숫자를 입력한 경우