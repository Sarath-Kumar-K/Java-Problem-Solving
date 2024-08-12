

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print(0+" "+1);
        fibonacci(0,1,10);
    }

    static void fibonacci(int first,int second,int n){
        if(n==1){
            return;
        }else{
            System.out.print(" "+(first+second));
            n--;
            fibonacci(second, first+second, n);
        }
    }

    static int fibo(int n){
        if(n<2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
