package tess;

public class MyCalculator implements Calculator{
    public int plus(int a, int b){
        return a+b;
    } // a + b 값 반환
    public int minus(int a, int b){
        return a-b;
    } // a - b 값 반환
    public int mul(int a, int b){
        return a*b;
    } // a * b 값 반환
    public int div(int a, int b){
        return a/b;
    } // a / b 값 반환
}
