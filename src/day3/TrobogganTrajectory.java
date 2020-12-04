package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TrobogganTrajectory {
    public static void main(String[] args) throws Exception {

        Scanner list = new Scanner(new File(System.getProperty("user.dir") + "/src/day3/input.txt"));
        ArrayList<CircularLinkedList<Character>> rows = new ArrayList<>();

        //skip the first row, as the starting point is predefined and we only start counting trees from the second row
        list.nextLine();

        //parse the input into rows of trees
        while (list.hasNext()) {
            CircularLinkedList<Character> row = new CircularLinkedList<Character>();
            for (Character c : list.nextLine().toCharArray()) {
                row.add(c);
                System.out.print(c + " ");
            }
            System.out.println();
            rows.add(row);
        }

        //iterate through each row diagonally and count #'s
        int numTrees = 0;
        int column = 0;
        for (CircularLinkedList<Character> character : rows) {
            column += 3;
            if (character.get(column) == '#') numTrees++;
        }
        System.out.println("You sled by " + numTrees + " tree/s.");
    }
}
