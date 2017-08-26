import java.util.Stack;

import jdk.nashorn.internal.ir.WhileNode;

public class test_pycode{
    public static void main(String [] args){
        int baseT = 3;
        int targetT = 2;

        Stack<Integer> s = toDigits(42, baseT);
        System.out.println(s);

        int x = fromDigits(s,targetT);
        System.out.println(x);

        Stack<Integer> s1 = convertBase(s, baseT, targetT);
        System.out.println(s1);

    }

    public static Stack<Integer> toDigits(int n, int b){
        //int [] digits = n.toArray();
     
        Stack<Integer> s = new Stack<Integer>();

        while(n > 0){
            int x = n / b;
            int y = x % b;
            n = x;
            System.out.println(n);
          
            s.push(y);
        }
        return s;
    }
    public static int fromDigits(Stack<Integer> digits, int b){
        int n=0;
        for (int d : digits) {
            n = n * b + d;
            System.out.println(n);
        }
        return n;
    }

    public static Stack<Integer> convertBase(Stack<Integer> digits, int b, int c){
        return toDigits(fromDigits(digits, b), c);
    }
}



// def toDigits(n, b):
//     """Convert a positive number n to its digit representation in base b."""
//     digits = []
//     while n > 0:
//         digits.insert(0, n % b)
//         n  = n // b
//     return digits

// def fromDigits(digits, b):
//     """Compute the number given by digits in base b."""
//     n = 0
//     for d in digits:
//         n = b * n + d
//     return n


// >>> toDigits(42, 2)
// [1, 0, 1, 0, 1, 0]
// >>> toDigits(42, 3)
// [1, 1, 2, 0]
// >>> fromDigits([1,1,2,0],3)
// 42