import java.lang.Integer;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RecoverCalibration {
    public static int getFirstLast(String inputLine) {
        String justints = inputLine.replaceAll("[^0-9]", "");
        justints = "" + justints.charAt(0) +justints.charAt(justints.length() - 1);
        return Integer.parseInt(justints);
    }

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        try {
            File myInputFile = new File("inputFile.txt"); //modify this to work
            Scanner input = new Scanner(myInputFile);
            while (input.hasNextLine()) {
                String inputLine = input.nextLine();
                values.add(getFirstLast(inputLine));
            }
            System.out.println("Reconstructed values: ");
            int sum = 0;
            for (int i = 0; i < values.size(); i++) {
                System.out.println(values.get(i));
                sum = sum + values.get(i);
            }
            System.out.println("Sum: " + sum);
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
