import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
        System.out.println(returnDice("", 5));;
    }

    static void subSeq(String up,String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeq(up.substring(1), p+ch);
        subSeq(up.substring(1), p);
    }

    static ArrayList<String> subSeqRet(String up,String p){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(!p.isEmpty()){
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeqRet(up.substring(1), p+ch);
        ArrayList<String> right = subSeqRet(up.substring(1), p);

        left.addAll(right);
        return left;
    }
    // getting a target from various throws of a dice
    static void dice(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i<=target; i++) {
            dice(p+i,target-i);
        }
    }
    // same reutrning the possible combinations as a list 
    static ArrayList<String> returnDice(String p,int target){
        if(target==0){
            ArrayList<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= 6 && i<=target; i++) {
            res.addAll(returnDice(p+i,target-i));
        }

        return res;
    }
}
