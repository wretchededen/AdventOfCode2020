package day4;

import java.io.File;
import java.util.*;

public class PassportProcessing {
    public static void main(String[] args) throws Exception {
        Scanner lines = new Scanner(new File(System.getProperty("user.dir") + "/src/day4/input.txt"));

        //parse the input into a suitable format
        HashMap<String, String> passportData;
        List<HashMap<String, String>> providedPassports = new ArrayList<>();

        while (lines.hasNext()) {
            String passport = "";
            while (lines.hasNext()) {
                String line = lines.nextLine() + " ";
                if (line.equals(" ")) break;
                passport += line;
            }
            passportData = new HashMap<>();
            for (String keyVal : passport.split(" ")) {
                String[] pair = keyVal.split(":");
                passportData.put(pair[0], pair[1]);
            }
            providedPassports.add(passportData);
        }

        String[] requiredFields = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        int numOfValidPassports = 0;
        for (HashMap<String, String> currentPassport : providedPassports) {
            boolean isValidPassport = true;
            for (String requiredKey : requiredFields) {
                if (!currentPassport.containsKey(requiredKey)) {
                    isValidPassport = false;
                    break;
                }
            }
            numOfValidPassports += isValidPassport ? 1 : 0;
        }
        System.out.println("The databse has "+numOfValidPassports+" valid Passports.");
    }
}
