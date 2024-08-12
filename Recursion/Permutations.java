import java.util.*;
class Permutations {
    public static void main(String[] args){
        String up = "7";
        int start = ((up.charAt(0)-'0')-2)*3;
        char startChar = (char)('a'+ ((up.charAt(0)=='8' || up.charAt(0)=='9')? start+1:start));
        int limit = (up.charAt(0)==7 || up.charAt(0)==9)? 4:3;
        System.out.println(limit);
        for (int i = 0; i < limit; i++) {
            System.out.println((char)(startChar+i));
        }
    }
    public static void printPermutation(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        for (int i = 0; i <=p.length(); i++) {
            String first = p.substring(0,i);
            char ch = up.charAt(0);
            String second = p.substring(i,p.length());
            printPermutation(first+ch+second, up.substring(1));
        }
    }
    static ArrayList<String> ReturnPermutations(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <=p.length(); i++) {
            String first = p.substring(0,i);
            char ch = up.charAt(0);
            String second = p.substring(i,p.length());
            ans.addAll(ReturnPermutations(first+ch+second, up.substring(1)));
        }
        return ans;
    }
    static ArrayList<String> returnPermutations(String p,String up,ArrayList<String> result){
        if(up.isEmpty()){
            result.add(p);
            return result;
        }
        for (int i = 0; i <=p.length(); i++) {
            String first = p.substring(0,i);
            char ch = up.charAt(0);
            String second = p.substring(i,p.length());
            returnPermutations(first+ch+second, up.substring(1),result);
        }

        return result;
    }
    public static int countPermutation(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        for (int i = 0; i <=p.length(); i++) {
            String first = p.substring(0,i);
            char ch = up.charAt(0);
            String second = p.substring(i,p.length());
            count += countPermutation(first+ch+second, up.substring(1));
        }

        return count;
    }
}