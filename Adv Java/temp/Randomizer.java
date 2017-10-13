import java.io.*;
import java.util.Random;

public class Randomizer {
public static void main(String[] args) throws IOException {

    PrintWriter output = new PrintWriter("randomNumbers.txt");
    final int randomNumberCount = 10000;
    Random randomGenerator = new Random();

    for (int i = randomNumberCount; i >= 0; i--){
        output.print(randomGenerator.nextInt(10000) + " ");
        if(i % 10 == 0){
            output.print("\n");
        }
    }
    output.close();

  }
}