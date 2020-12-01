package Day1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReportRepairFromThreeNumbers {

    public static void main(String[] args) throws Exception {
        int answer;
        List<Integer> numbers = new ArrayList<>();

        Scanner list = new Scanner(new File(System.getProperty("user.dir") + "/src/Day1/input.txt"));
        while (list.hasNext()) {
            numbers.add(Integer.parseInt(list.next()));
        }

        findFromThreeNumbers(numbers);
    }

    public static void findFromThreeNumbers(List<Integer> numbers) {
        Iterator<Integer> i = numbers.iterator();

        while (i.hasNext()) {
            int number1 = i.next();

            for (int j = 1; j < numbers.size() - 1; j++) {
                int number2 = numbers.get(j);
                for (int k = j + 1; k < numbers.size() - 2;k++){
                    int number3 = numbers.get(k);
                    if (number1 + number2 + number3 == 2020) {
                        System.out.println("Bingo! "
                                + number1 + " + " + number2 + " + " + number3 + " = 2020");
                        System.out.println("Answer: "+ number1*number2*number3);
                    }
                }
            }
            i.remove();
        }
    }
}
