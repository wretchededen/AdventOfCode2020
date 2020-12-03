package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TrobogganTrajectory {
    public static void main(String[] args) throws Exception {

        Scanner list = new Scanner(new File(System.getProperty("user.dir") + "/src/day3/input.txt"));
        ArrayList<CircularLinkedList<Character>> input = new ArrayList<>();
        while (list.hasNext()) {
            CircularLinkedList<Character> row = new CircularLinkedList<Character>();
            for (Character c : list.nextLine().toCharArray()) {
                row.add(c);
                System.out.print(c + " ");
            }
            System.out.println();
            input.add(row);
        }

        input.remove(0);
        int numTrees = 0;
        int hPos = 0;
        for (CircularLinkedList<Character> C : input) {
            hPos += 3;
            if (C.get(hPos) == '#') numTrees++;
        }
        System.out.println("You sled by " + numTrees + " tree/s.");
    }
}
