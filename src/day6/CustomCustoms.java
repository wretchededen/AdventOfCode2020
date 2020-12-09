package day6;

import java.io.File;
import java.util.*;

public class CustomCustoms {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/day6/input.txt"));

        List<Set<Character>> groups = new ArrayList<>();
        Set<Character> group = new HashSet<>();

        while (input.hasNext()) {
            String entry = input.nextLine(); // Need to use nextLine() because next() skips the empty delimiter of
            if (entry.equals("")) {
                groups.add(group);
                group = new HashSet<>();
                continue;
            }
            for (Character positiveQuestion : entry.toCharArray()) {
                group.add(positiveQuestion);
            }
        }
        groups.add(group); // Add the last group as it's not followed by an empty line

        int totalAnswers = 0;
        for (Set<Character> g : groups){
            totalAnswers += g.size();
        }
        System.out.println("Number of total unique answers per group for all groups: "+ totalAnswers);
    }
}
