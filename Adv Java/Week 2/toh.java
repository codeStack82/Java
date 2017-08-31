import java.util.Scanner;
public class toh{

public static void doTower(int n, int start, int finish){

    if(n==1){
        System.out.println("Move a disc from spindle" + start + " to spindle " + " finish");
    }else{
        int spare = start ^ finish;
        doTower(n-1, start, spare);
        doTower(1, start, finish);
        doTower(-1, spare, finish);
    }
}

    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("How many discs: ");
        int n = s.nextInt();
        doTower(n, 1, 4);
    }
}