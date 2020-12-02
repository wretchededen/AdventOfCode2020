package day2;

import java.io.File;
import java.util.Scanner;

public class PasswordPhilosophy {

    public static void main(String[] args) throws Exception {
        int policyFloor;
        int policyCeiling;
        char policyChar;
        String password;
        int answer = 0;

        Scanner list = new Scanner(new File(System.getProperty("user.dir") + "/src/day2/input.txt"));
        while (list.hasNext()) {
            String row = list.nextLine();
            String[] temp = row.split(": ");
            if (temp.length < 1) continue;
            password = temp[1];
            policyChar = temp[0].split(" ")[1].toCharArray()[0];
            policyFloor = Integer.parseInt(temp[0].split("-")[0]);
            policyCeiling = Integer.parseInt(temp[0].split("-")[1].split(" ")[0]);

            int occurences = 0;
            for (char c : password.toCharArray()) {
                if (c == policyChar) occurences++;
            }
            if (occurences >= policyFloor && occurences <= policyCeiling) {
                answer++;
            }
        }
        System.out.println("There are " + answer + " passwords matching company policy");
    }
}
