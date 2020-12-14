package day7;

import java.io.File;
import java.util.*;

public class HandyHaversacks {

    static Map<String, List<String>> bags = new HashMap<>();
    static Set<String> endpointBags = new HashSet<>();

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/day7/input.txt"));

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] parentAndChildrenBags = line.split(" bags contain ");
            String parentBag = parentAndChildrenBags[0];

            if (parentAndChildrenBags[1].equals("no other bags.")) {
                bags.put(parentBag, new ArrayList<String>());
                System.out.println(parentBag + " bag contains: " + bags.get(parentBag).toString());
                continue;
            }

            String childrenData = parentAndChildrenBags[1];
            int delimiter = childrenData.indexOf(" ") + 1;
            childrenData = childrenData.substring(delimiter);
            List<String> children = Arrays.asList(childrenData.split(" ba(g|gs), \\d | ba(g|gs)\\."));
            bags.put(parentBag, children);
            System.out.println(parentBag + " bag contains: " + bags.get(parentBag).toString());
        }
        Map<String, String> sensibleBagRelationshipMap = new HashMap<>();

        String startingBag = "shiny gold";
        hasParentBag(startingBag);
        endpointBags.remove(startingBag);
        System.out.println("There are " + endpointBags.size() + " endpoints. They are: " + endpointBags.toString());
    }

    private static void hasParentBag(String currentBag) {
        for (Map.Entry<String, List<String>> bagRelationshipSet : bags.entrySet()) {
            if (bagRelationshipSet.getValue().contains(currentBag)) {
                System.out.println(currentBag + " has a parent!");
                endpointBags.add(bagRelationshipSet.getKey());
                hasParentBag(bagRelationshipSet.getKey());
            }
        }
    }
}
