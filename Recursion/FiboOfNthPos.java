package Recursion;

public class FiboOfNthPos {
    public static void main(String[] args) {
        int pos = 7;
        System.out.println(fibo(pos));
    }

    static int fibo(int n){
        if(n<2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
