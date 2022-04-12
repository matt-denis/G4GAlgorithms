public class Test {


    
    static boolean foo(char c) 

    {

        System.out.print(c); 

        return true; 

    } 

    public static void main( String[] argv ) 

    {
        GFG obj1 = new GFG();

        GFG obj2 = obj1;

 

        obj1.a += 1;

        obj1.b += 1;

 

        System.out.println ("values of obj1 : ");

        obj1.print();

        System.out.println ("values of obj2 : ");

        obj2.print();
    }

    
}
        
class GFG

{

    int a, b;

     

    GFG()

    {

        a = 10;

        b = 20;

    }

     

    public void print()

    {

        System.out.println ("a = " + a + " b = " + b);

    }

}