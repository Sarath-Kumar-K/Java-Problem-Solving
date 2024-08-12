

public class Strings {
    public static void main(String[] args) {
        
    }
    // with return
    static String skipCharA(String str){
        char ch = str.charAt(0);
        if(str.length()==1){
            return (ch == 'a' || ch == 'A')?"":Character.toString(ch);
        }else{
            return ((ch == 'a' || ch == 'A')?"":Character.toString(ch)) + skipCharA(str.substring(1));
        }
    }
    // without return
    static void skipCharA(String str,String result){
        if(str.isEmpty()){
            System.out.println(result);
            return;
        }
        char ch = str.charAt(0);
        if(ch == 'a' || ch == 'A'){
            skipCharA(str.substring(1), result);
        }else{
            skipCharA(str.substring(1), result+ch);
        }
    }
    
}
