package tess;

public class MyCalculator implements Calculator{
    public int plus(int a, int b){
        return a+b;
    }
    public int minus(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public int div(int a, int b){
        return a/b;
    }
}
