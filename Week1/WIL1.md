# WIL1 : Java와 객체 지향 프로그래밍

<br/>

## Java

**_객체지향 프로그래밍 언어_**

&nbsp; 특징

1. 운영체제에 독립적
2. 객체지향언어

- 상속, 캡슐화, 다형성이 잘 적용된 순수한 객체지향언어
- 재사용성과 유지보수의 용이성

3. 자동 메모리 관리, 네트워크 분산처리 지원, 멀티쓰레드 지원, 동적 로딩 지원

<br/>

## 객체지향 프로그래밍

> 객체지향: 실세계를 직접적이고 직관적으로 모델링 할 수 있는 패러다임

> 객체: 현실 세계에 존재하는 사물에 대한 추상화

현실 속에 존재하는 사물을 최대한 유사하게 모방해 소프트웨어 내부로 옮겨오는 작업

즉, 프로그래밍에서 필요한 데이터를 추상화시켜 *상태와 행위를 가진 객체*로 만들고 *객체들간의 상호작용*을 통해 로직을 구성함

&nbsp; 특징

1. **추상화**

- 객체에서 공통된 속성과 행위를 추출
- 불필요한 정보는 숨기고 중요한 정보만을 표현 <br/> <br/>

2. **캡슐화**

- 데이터 구조와 데이터를 다루는 방법들을 결합시켜 묶는 것
- *낮은 결합도를 유지*할 수 있도록 설계
- _속성과 기능을 정의하는 **변수**와 **메소드**를 `클래스`라는 캡슐에 넣어서 분류하는 것_
- _재사용_ 원활, _정보은닉_ 을 활용 <br/> <br/>

3. **상속**

- 하위 클래스가 상위 클래스의 속성과 행위를 물려받음 <br/> <br/>

4. **다형성**

- 하나의 변수명, 함수명이 상황에 따라 다른 의미로 해석될 수 있음
- 어떠한 요소에 여러 개념을 넣어 놓는것<br/>

  > **오버라이딩** <br/> 상위 클래스가 가지고 있는 메소드를 하위 클래스가 재정의해서 사용하는 것

  > **오버로딩** <br/> 같은 이름의 메소드가 인자의 개수나 자료형에 따라 다른 기능을 하는 것

  <br/>

## 자바의 객체 지향

### 클래스

어떠한 행위를 맡길 객체를 생성 <br/>
행위를 수행할 책임을 맡은 객체에게 상태 부여

```java
public class Person {
    // 맴버 변수
    private int age;
    private String name;

    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // method
    public void hello(){
        System.out.println("hello");
    }
}
```

1. 멤버 변수 : `name`, `age`
2. 생성자 : `Person`
3. 메서드 : `hello` 객체의 행동을 정의
4. getter와 setter 메서드 : `getName`, `setName`, `getAge`, `setAge` 메서드는 멤버 변수인 `name`과 `age`에 접근하고 수정하기 위한 메서드
   <br/>

### 캡슐화

`Person` 클래스의 멤버 변수인 `name`과 `age`를 `private`으로 선언하여 **외부에서 직접 접근할 수 없도록** 하고 <br/>
`setName`과 `setAge` **메서드를 통해** _데이터를 설정_ 하며, `getName`과 `getAge` **메서드를 통해** _데이터를 조회_

<br/>

### 상속

```java
class HarryPotter extends Person {
    public HarryPotter(String name, int age) {
        super(name, age); // 상위 클래스의 생성자 호출
    }

    // HarryPotter 클래스만의 메서드 추가
    public void Lumos() {
        System.out.println("Lumos");
    }

    @Override //자바 어노테이션
    public void hello() {
        System.out.println("hello I'm " + this.getName());
    }
}
```

<br/>

### 다형성

```java
class Voldemort extends Person {
    public Voldemort(String name, int age) {
        super(name, age); // 상위 클래스의 생성자 호출
    }

    // Voldemort 클래스만의 메서드 추가
    public void avadaKedavra() {
        System.out.println("Avada Kedavra");
    }

    @Override
    public void hello() {
        System.out.println("hello I'm " + this.getName());
    }
}
```

다형성을 통해 `HarryPotter`와 `Voldemort`은 각자의 클래스에 정의된 `hello` 메서드를 호출하면, <br/>
해당 객체의 오버라이드된 메서드가 실행됨 <br/>
이렇게 _동일한 메서드 호출_ 로 인해 서로 다른 객체에 대한 다양한 동작을 구현할 수 있음

<br/>

### 추상화

```java
// 추상 클래스 예제
abstract class Shape {
  // 추상 메서드
  public abstract double calculateArea();
}

class Circle extends Shape {
  private dounle radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  // 원의 넓이 계산
  @Override
  public double calculateArea(){
    return Math.PI * radius * radius;
  }
}

class Rectangle extends Shape {
  private double width;
  private double height;

  public Rectangle(double width, double height){
    this.width = width;
    this.height = height;
  }

  // 직사각형의 넓이 계산
  @Override
  public double calculateArea() {
    return width * height;
  }
}

public class Main {
  public static void main(String[] args) {
    // 객체 생성
    Circle circle = new Circle(5.0);
    Rectangle rectangle = new Rectangle(4.0, 6.0);

    Shape[] shapes = { circle, rectangle };

    // 모든 도형의 넓이 출력
    for (Shape shape : shapes) {
      // for(타입 변수명:배열 or 컬렉션)
      // 배열 or 컬렉션에 저장된 값이 매 반복마다 하나씩 순서대로 읽혀져
      // 변수에 저장된다
      System.out.println("넓이: " + shape.calculateArea());
    }
  }
}
```

`Circle` 클래스와 `Rectangle` 클래스는 `Shape` 추상 클래스를 상속받아 추상 메서드를 구현

이를 통해 `Shape` 타입으로 다양한 도형 객체를 다룰 수 있으며, <br/>
각 도형의 넓이를 간결하게 계산할 수 있음
