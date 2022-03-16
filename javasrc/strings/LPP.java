package strings;

public class LPP {
    

    // NAIVE
    static int longPropPreSuff(String str, int n){
        for(int len=n-1;len>0;len--){
            boolean flag=true;
            for(int i=0;i<len;i++)
                if(str.charAt(i)!=str.charAt(n-len+i))
                    flag=false;
                    
            if(flag==true)
                return len;
        }
        return 0;
        }
    
    static void fillLPSCubic(String str, int lps[]){
        for(int i=0;i<str.length();i++){
            lps[i]=longPropPreSuff(str,i+1);
        }
    }
}
