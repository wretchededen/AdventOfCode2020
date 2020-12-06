package day5;

import java.io.File;
import java.util.*;

public class BinaryBoarding {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File(System.getProperty("user.dir") + "/src/day5/input.txt"));

        List<String> boardingPasses = new ArrayList<>();
        while (s.hasNext()) boardingPasses.add(s.nextLine());
        List<Integer> seatsIDs = new ArrayList<>();

        for (String pass : boardingPasses) {
            int maximumRow = 127, minimumRow = 0,
                    maximumCol = 7, minimumCol = 0,
                    diff, row, column, seatID;
            char[] criterias = pass.toCharArray();
            for (int i = 0; i < 7; i++) {
                diff = maximumRow - minimumRow + 1;
                if (criterias[i] == ('F')) {
                    maximumRow -= diff / 2;
                } else minimumRow += diff / 2;
                System.out.println("Rows: " + minimumRow + " " + maximumRow);
            }
            row = maximumRow;
            for (int i = 7; i < 10; i++) {
                diff = maximumCol - minimumCol + 1;
                if (criterias[i] == 'L') maximumCol -= diff / 2;
                else minimumCol += diff / 2;
                System.out.println("Columns: " + minimumCol + " " + maximumCol);
            }
            column = maximumCol;
            seatID = row * 8 + column;
            seatsIDs.add(seatID);
        }
        Collections.sort(seatsIDs,Collections.reverseOrder());
        System.out.println("Highest seatID is "+seatsIDs.get(0));
    }
}
