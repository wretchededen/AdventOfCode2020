package day8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandheldHalting {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/day8/input.txt"));
        ArrayList<String> rows = new ArrayList<>();
        while (input.hasNext()) {
            rows.add(input.nextLine());
        }
        String[] instructions = rows.toArray(new String[]{});
        int accumulator = 0;

        for (int index = 0; index < instructions.length; index++) {
            String[] instruction = instructions[index].split(" ");
            String operation = instruction[0];
            int command = Integer.parseInt(instruction[1]);

            switch (operation) {
                case "acc":
                    instructions[index] = "BREAK 1";
                    accumulator += command;
                    break;
                case "jmp":
                    instructions[index] = "BREAK 1";
                    index += command - 1;
                    break;
                case "nop":
                    instructions[index] = "BREAK 1";
                    break;
                case "BREAK":
                    System.out.println("The accumulator value is: " + accumulator);
                    System.exit(0);
            }
        }
    }
}
