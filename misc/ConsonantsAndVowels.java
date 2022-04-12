public class ConsonantsAndVowels {
    
    static void checkString(String s)
    {
        int v=0;
        int c=0;
        final String vowels = "aeiou";
        
        //Your code here
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) v++;
            else c++;
        }
        
        if(v>c)
        System.out.print("Yes");
        else if(c>v)
        System.out.print("No");
        else
       System.out.print("Same");
        
        System.out.println();
    }

    public static void main(String[] args) {
        
    }
}
