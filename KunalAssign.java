import java.util.Scanner;
class KunalAssign {
    public static void main(String[] args) {
        

       Xtoexit();

    }

    static void isLeapYear(){
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        //checking year%4==0 && year%100 !=0 for non century years, checking year%400 for cntury years.
        if((year%4 == 0 && year%100 != 0) || year%400 == 0){
            System.out.println(year + " is a Leap Year");
        }else System.out.println(year + " is Not a Leap Year");
        input.close();
    }

    static void LCMandGCD(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two number to find its LCM and GCD:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        input.close();


        int smaller,larger;
        if(num1 < num2){
            smaller = num1;
            larger = num2;
        }else{
            smaller = num2;
            larger = num1;
        }
        // for lowest common multiple
        int i=1,lcm;
        while(true){
            if((larger*i)%smaller == 0){
                lcm = larger * i;
                break;
            }else i++;
        }
        // for greatest common divisor
        int gcd=1;
        for (int j = smaller; j >1 ; j--) {
            if(smaller%j==0 && larger%j == 0){
                gcd = j;
                break;
            }
        }

        System.out.println("LCM = "+lcm+" GCD = "+gcd);
    }

    static void Xtoexit(){
        System.out.println("Enter numbers to add and x to exit:");
        int sum =0;
        Scanner input = new Scanner(System.in);
        while(true){
            String nums = input.nextLine();
            if(nums.equals("x")){
                input.close();
                break;
            }else{
                sum+=Integer.parseInt(nums);
            }
        }
        System.out.println(sum);
    }
}