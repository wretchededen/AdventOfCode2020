package Day1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReportRepairFromTwoNumbers {

    public static void main(String[] args) throws Exception {
        int answer;
        List<Integer> numbers = new ArrayList<>();
        Scanner list = new Scanner(new File(System.getProperty("user.dir") + "/src/Day1/input.txt"));

        while (list.hasNext()) {
            numbers.add(Integer.parseInt(list.next()));
        }

        findFromTwoNumbers(numbers);
    }

    public static void findFromTwoNumbers(List<Integer> numbers){
        Iterator<Integer> i = numbers.iterator();
        while (i.hasNext()) {
            int number1 = i.next();
            for (int number2 : numbers) {
                if (number1 + number2 == 2020) {
                    System.out.println("Bingo! Found the combo: " + number1 + " + " + number2 + " = 2020!");
                    System.out.println("The answer is: " + number1 * number2);
                    System.exit(0);
                }
            }
            i.remove();
        }
    }
}
