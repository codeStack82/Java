import java.util.Scanner;

public class W3_ClassProgram{
    public static void main(String [] args){

        //Create dynamic array
        int theArray [];
        int size;
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the Array Demo\n");
        System.out.print("Please enter a size: ");
        
        //Get Size
        size = s.nextInt();
        theArray = new int[size];

        //Randomize and Display array
        //displayArray(theArray);   //displays zero's
        randomizeArray(theArray);
        displayArray(theArray);

        //Copy array to new larger 2x array
        int[] tempArray = new int[size *2];
        copyArray(theArray, tempArray);
        size = size * 2;
        theArray = tempArray;
        System.out.println("Array copied and size is now 2x");
        //display that the array is now 2x larger
        displayArray(theArray);                 

        //Test sequential search function
        System.out.print("Please enter a search value:");
        int num = s.nextInt();
        Boolean hasValue = sequentialSearch(theArray, num);

        System.out.println("Array as Value: " + hasValue);

        //What is an inversion?  Its a list(or array) that is out of order
            //Ex: 42 3 5 87 34 5 9 7 68 44 
            //Exchange sort - after first pass the biggest number is all the way at the end
            //Exchange sort make array lengh-1 factorial = 9!
            //Theta(n^2)  quadratic algorythm

        //Insertion sort O(n^2) quadratic algorythm
            //much faster on semi sorted lists

        //Selction sort 
            //Theta(n^2)  quadratic algorythm

        //Advanced sorts are nLgn (n log n)
            //Binary Merge Sort nLgn (n log n)
            //Natural Merge Sort OnLgn O(n log n)


    }

    public static void randomizeArray(int [] a){
        for(int i = 0; i < a.length; i++){
            a[i] = (int)(Math.random()* 1000);
        }
    }

    public static void copyArray(int [] source, int[] dest){
        for(int i =0; i < source.length; i++){
            dest[i] = source[i];
        }
    }

    public static boolean sequentialSearch(int[] arr, int s){
        boolean result = false;
        for(int i = 0; i < arr.length; i++){
            if(s == arr[i]){
                result = true;
                break;
            }
        }
        return result;
    } 

    public static boolean binarySearch(int [] a){

    }

    public static void displayArray(int [] a){
        for(int i = 0; i < a.length; i++){
            if (i % 10 == 0){
                System.out.println();
            }
            System.out.printf("%7d",a[i]);
        }
        System.out.printf("\n");

    }

    public static void displayLongArray(int a []){
        if ( a.length <= 200 ){
            for(int i = 0; i < a.length; ++i){
                if ( i%10 == 0 ){
                System.out.println();
                }
                System.out.printf("%7d", a[i]);
            }
        }
            else{
            for(int i = 0; i < 100; ++i){
                if ( i%10 == 0 ){
                System.out.println();
                }
                System.out.printf("%7d", a[i]);
            }
            System.out.println();
            System.out.println("----------------------------------------------");
            for(int i = a.length - 100; i < a.length; ++i){
                if ( i%10 == 0 ){
                System.out.println();
                }
                System.out.printf("%7d", a[i]);
            }
        }
            System.out.println();
            System.out.println();
    }
    
}