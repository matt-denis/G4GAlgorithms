package strings;


public class KMP {

    public static void main(String[] args) {
        display(lpp("abacabad"));
        display(lpp("abbabb"));
    }

    // KMP Algorithm
    public static void KMPmatch(String pat, String txt) {
        int n = txt.length(), m = pat.length();
        int[] lps = new int[m];
        fillLPS(pat, lps);
        int i = 0, j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) { i++; j++; }
            if (j == m) System.out.print(i - m + " ");
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j == 0) i++;
                else j = lps[j - 1];  // length of lpp of substring ending with last char matched
            }
        }
    }

    public static void fillLPS(String s, int[] lps) {
        int n = s.length(), len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            }
            else if (len == 0) {
                lps[i++] = 0;
            }
            else {
                len = lps[len - 1];
            }
        }
    }


    // ================= longest proper prefix O(n^3) =======================

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

    // -------------------------------------------------------------------

    public static int[] lpp(String s) {
        if (s.length() == 0) return new int[0];
        int[] arr = new int[s.length()];  // first val initialized to 0 as it should
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    int walk = j;
                    for ( ; walk >= 0; walk--) {
                        if (s.charAt(walk) != s.charAt(i - (j - walk))) break;
                    }
                    if (walk == -1) {
                        arr[i] = j + 1; // length == 1-based index
                        break;
                    }
                }
            }
        }
        return arr;
    }

    private static void display(int[] a) {
        for (var e : a) System.out.print(e + " ");
        System.out.println();
    }
    
}