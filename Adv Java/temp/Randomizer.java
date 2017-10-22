import java.io.*;
import java.util.Random;

public class Randomizer {
public static void main(String[] args) throws IOException {

    PrintWriter output = new PrintWriter("identicalList.txt");
    final int randomNumberCount = 1000000;
    Random randomGenerator = new Random();

    for (int i = randomNumberCount; i >= 0; i--){
        output.print(randomGenerator.nextInt(1000000) + " ");
        if(i % 50 == 0){
            output.print("\n");
        }
    }
    output.close();

  }
}