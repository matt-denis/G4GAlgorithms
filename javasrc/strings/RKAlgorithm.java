package strings;

public class RKAlgorithm {

    static final int d=256;
    static final int q=101;   

    static void RBSearch(String pat, String txt, int M, int N) {
    
        //Compute (d^(M-1))%q
        int h=1;
        for (int i = 1; i <= M - 1; i++)
            h = (h * d) % q;
        
        //Compute p and t
        int p = 0, t = 0;
        for (int i = 0; i < M; i++){
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }
        
        for(int i = 0; i <= (N - M); i++){
           //Check for hit
           if (p == t){
               boolean flag = true;
               for (int j = 0; j < M; j++)
                    if (txt.charAt(i+j) != pat.charAt(j)) { flag = false; break; }
                if (flag) System.out.print(i + " ");
            }
           //Compute ti+1 using ti
           if (i < N - M) {
               t=((d * (t - txt.charAt(i) * h)) + txt.charAt(i+M)) % q;
            if (t < 0) t = t+q;
           }
        }
    }

    public static void main(String[] args) {
        search("abdabcbabc", "abc");
    }

    public static void search(String t, String p) {
        int m = p.length(), n = t.length();
        long pHash = 0, tHash = 0;
        for (int i = 0; i < m; i++) {
            pHash += Character.valueOf(p.charAt(i)).hashCode();
        }
        for (int i = 0; i < m; i++) {
            tHash += Character.valueOf(t.charAt(i)).hashCode();    
        }
        for (int k = 0; k < n - m + 1; k++) {
            if (pHash == tHash && isMatch(t, p, k, m)) {
                System.out.print(k + " ");
            }
            if (k < n - m) { 
                // update window hash for next iteration: have to check whether current
                // iteration is last one to oavoid index out of bounds
                tHash += Character.valueOf(t.charAt(k + m)).hashCode() -
                    Character.valueOf(t.charAt(k));
            }
        }
    }
            
    
    /**
     * 
     * @param t text
     * @param p pattern
     * @param start starting index
     * @param m length of pattern
     * @return true if it's a match
     */
    private static boolean isMatch(String t, String p, int start, int m) {
        int i;
        for (i = start; i < start + m; i++) {
            if (t.charAt(i) != p.charAt(i - start)) break;
        }
        return i == start + m;
    }
}