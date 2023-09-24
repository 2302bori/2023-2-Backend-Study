# HTTP

> 서로 다른 시스템들 사이에서 통신을 주고받게 해주는 application 계층의 protocal

HyperText Transfer Protocol 의 약자

웹에서만 사용하는 포로토콜

TCP/IP 기반으로 서버와 클라이언트 간의 요청과 응답을 전송

Hypertext: 다른 페이지의 링크를 담고 있는 문서

**TCP**

- 네트워크 계층의 network layer에서 사용하는 프로토콜

### **특징**

- Transfer layer
- 비 연결성

클라이언트와 서버가 한번 연결을 맺은 후에 클라이언트의 요청에 대해 서버가 응답을 마치면 연결을 끊어버림

- 무상태성

비 연결성으로 인해 서버가 두 요청간의 어떠한 데이터도 유지하지 않음

즉, 서버는 클라이언트와 연결에 대한 정보를 저장하지 않음

그래서 서버는 클라이언트를 식별하지 못함

### **HTTP 연결**

1. TCP연결 열어준다. (TCP 연결은 요청을 보내거나 받는데 사용)
2. HTTP메시지 전송한다.
3. 서버가 보낸 응답을 읽는다.
4. 연결을 닫거나 다른 요청을 위해 재사용한다

### **HTTP Message**

HTTP는 HTTP message를 통해 데이터를 주고받음

1. request
2. response

http methon / 경로 / http 버전 / 헤더

### **HTTP Method**

클라인언트가 서버에 특정 요청을 보낼때, 웹서버에게 요청하는 목적 및 그 종류를 알리는 수단

GET: 리소스 조회

POST: 요청 데이터 처리, 주로 등록에 사용

PUT: 리소스를 대체, 해당 리소스가 없으면 생성

PATCH: 리소스 부분 변경

DELETE: 리소스 삭제

HEAD: GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 반환

OPTIONS: 대상 리소스에 대한 통신 가능 옵션(메서드)을 설명(주로 CORS에서 사용)

CONNECT: 대상 리소스로 식별되는 서버에 대한 터널을 설정

TRACE: 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행

### HTTP 상태 코드

서버측에서 클라이언트로 요청에 대한 _응답_ 을 보낼 때, 해당 요청에 관한 처리 _상태_ 를 알려주는 기능

1xx (Informational): 요청이 수신되어 처리중

2xx (Successful): 요청 정상 처리

3xx (Redirection): 요청을 완료하려면 추가 행동이 필요

4xx (Client Error): 클라이언트 오류, 잘못된 문법등으로 서버가 요청을 수행할 수 없음

5xx (Server Error): 서버 오류, 서버가 정상 요청을 처리하지 못함

200 : 클라이언트의 요청을 정상적으로 수행함

201 : 클라이언트가 어떠한 리소스 생성을 요청, 해당 리소스가 성공적으로 생성됨(POST를 통한 리소스 생성 작업 시)

204 : 클라이언트가 어떠한 리소스 삭제를 요청, 해당 리소스가 성공적으로 삭제됨

400 : 클라이언트의 요청이 부적절 할 경우 사용하는 응답 코드

401 : 클라이언트가 인증되지 않은 상태에서 보호된 리소스를 요청했을 때 사용하는 응답 코드

403 : 유저 인증상태와 관계 없이 응답하고 싶지 않은 리소스를 클라이언트가 요청했을 때 사용하는 응답 코드

404 : 클라이언트가 요청한 리소스에서는 사용 불가능한 Method를 이용했을 경우 사용하는 응답 코드

500 : 서버에 문제가 있을 경우 사용하는 응답 코드

502 : 게이트웨이 오류

<br/>

# HTTPS

> 하이퍼텍스트 전송 프로토콜 보안(HTTPS)은 웹 브라우저와 웹 사이트 간에 데이터를 전송하는 데 사용되는 기본 프로토콜인 *HTTP* 의 보안 버전

웹 사이트에서 네트워크를 스누핑하는 사람이 쉽게 볼 수 있는 방식으로 정보를 브로드캐스트하는 것을 방지

HTTPS를 사용하면 트래픽이 암호화되므로 패킷을 스니핑하거나 가로챈다고 해도 무의미한 문자로만 인식

### HTTP와의 차이점

HTTPS(Hypertext Transfer Protocol Secure)는 HTTP의 확장 버전 또는 더 안전한 버전

HTTPS에서는 브라우저와 서버가 데이터를 전송하기 전에 안전하고 암호화된 연결을 설정

<br/>

## RESTful한 URI

- 이벤트 목록 조회

```
GET      /events
```

- 이벤트 조회

```
GET      /events/{eventId}
```

- 이벤트 등록

```
POST     /events/{eventId}
```

- 이벤트 수정

```
PATCH      /events/{eventId}
```

- 이벤트 삭제

```
DELETE   /events/{eventId}
```

- 이벤트 상태 변경

```
PATCH    /events/{eventId}/states/{stateId}
```

- 특정 이벤트의 주문 목록 조회

```
GET      /events/{eventId}/orders
```

- 멤버 목록 조회

```
GET      /members
```

- 특정 멤버 권한 변경

```
PATCH    /members/{memberId}/rights/{rightId}
```

- 특정 멤버 정보 조회

```
GET      /members/{memberId}/datas/{dataId}
```

- 특정 멤버 정보 변경

```
PATCH    /members/{memberId}/datas/{dataId}
```

- 멤버 등록

```
POST      /members/{memberId}
```
