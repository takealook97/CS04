🎯 CS04 프로세스 메모리
=
---
## 학습목표
- 프로세스 메모리 관리모델 학습 및 동작 방식 구현
- 스택 영역, 힙 영역, 텍스트 영역, 글로벌변수 영역 의 역할과 동작방식을 이해하고 동작방식 구현
- 프로그래밍 언어 동작과 처리흐름을 이해
---
# 메모리 구조
- 스택영역 : 함수를 호출 할 때마다 정보가 쌓임. 함수에 대한 정보, 함수 안에 포함되어있는 지역변수를 포함한다.
- 힙영역 : 동적으로 할당되는 변수에 대한 데이터가 위치하는 공간. ex) c언어는 malloc과 같은 함수를 이용해서 동적할당
- BSS(uninitialized) : 프로그램에서 사용될 (아직 초기화가 안된)변수들이 실제로 위치하는 공간
- Data(initialized) : 초기화가 된 변수들이 위치하는 공간
- Text(Code) : 작성한 소스코드가 들어가는 공간




---
# Mission. 프로세스 메모리 시뮬레이터

- 메모리 주소를 값으로 다루는 포인터 변수 구현
- 프로그래밍 요구사항에 나와있는 함수들을 구현
- 함수 내부에서 출력하지 말고 함수에서 리턴한 값을 호출한 프로그램에서 출력
- Memory 객체 구현
  - 리턴 명세가 있는 경우 반드시 리턴
  - 스택 타입도 별도로 선언, 내부에는 스택 포인터 변수를 두고 몇번 쌓였는지 확인
- 함수
  - init(stackSize, heapSize) : 프로세스 공간을 위한 기본주소(base address)를 리턴
  - setSize(type, length) : type 별로 고유한 사이즈를 가지도록 등록
  - malloc(type, count) :
    - 등록된 type에 count만큼 반복해서 메모리할당
    - 고유한 시작위치주소를 스택영역에 추가
    - 스택주소값리턴
  - free(pointer) : malloc 시 할당했던 스택 주소값을 입력으로 받는다.
  - call(name, paramCount) : 마지막 스택 위치 알려주는 스택포인터에 변수를 paramCount만큼 반복해서 생성하고 스택포인터 증가
  - returnFrom(name) : 증가했던 스택 공간 비우고 이전 호출 위치로 이동
  - usage() : 정보들을 배열로 리턴
  - callstack() : 스택에 쌓여있는 호출 스택을 문자열로 리턴
  - heapdump() : 힙영역에서 사용중인 상태를 문자열 배열로 리턴
  - garbageCollect() : 스택에 포인터 변수가 없는 경우를 찾아서 해제
  - reset() : 모든 스택과 힙공간을 비우고 init했을 때와 동일하게 초기상태로 만듦