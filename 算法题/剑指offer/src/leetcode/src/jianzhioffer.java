package leetcode.src;

public class jianzhioffer {
    public static void main(String[] args) {
        String str="123";
        System.out.println(StrToInt(str));
    }
    public static int StrToInt(String str) {
        if(str==null||str.length()==0) return 0;
        if(str.length()==1&&!(str.charAt(0)>='0'&&str.charAt(0)<='9')) return 0;
        char c=str.charAt(0);
        int i=1,j=str.length()-1;
        if(c=='-'||c=='+'){
            while(i<j){
                if(!((str.charAt(i)>='0'&&str.charAt(i)<='9')&&((str.charAt(j)>='0'&&str.charAt(j)<='9')))){
                    return 0;
                }
                i++;j--;
            }
        }else{
            while(i<j){
                if(!((str.charAt(i)>='0'&&str.charAt(i)<='9')&&((str.charAt(j)>='0'&&str.charAt(j)<='9')))){
                    return 0;
                }
                i++;j--;
            }
        }
        return Integer.valueOf(str);
    }
}
