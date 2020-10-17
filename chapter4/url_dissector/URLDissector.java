package chapter4.url_dissector;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class URLDissector {
    public static void main(String[] args) throws IOException {
        String url;
        Scanner fileScan, urlScan;
        
        fileScan = new Scanner(new File("websites.inp"));

        while(fileScan.hasNext()){
            url = fileScan.nextLine();
            System.out.println("Url: " + url);

            urlScan = new Scanner(url);
            urlScan.useDelimiter("/"); // prints input into patterns

            while(urlScan.hasNext()){
                System.out.println(" " + urlScan.next());
            }

            System.out.println();

            urlScan.close();
        }

        fileScan.close();
    }
}
