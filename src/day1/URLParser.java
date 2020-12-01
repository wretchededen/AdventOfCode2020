package day1;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class URLParser<E> {
    String url;

    URLParser(String target) {
        this.url = target;
    }

    public List<E> getList() throws Exception {
        URL inputURL = new URL(url);
        Scanner scan = new Scanner(inputURL.openStream());
        ArrayList<E> temp = new ArrayList<>();

        while (scan.hasNext()) {
            E row;
            try {
                row = (E) scan.next();
                temp.add(row);
            }
            catch (Exception ignored){
            }
        }
        scan.close();
        return temp;
    }
}
