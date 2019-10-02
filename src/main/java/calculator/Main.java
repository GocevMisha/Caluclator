package calculator;

import java.util.Scanner;

public class Main {
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reader reader = new Reader(scanner);
        Writer writer = new Writer(System.out);
        CalculateManager calculateManager = new CalculateManager(reader, writer);
        calculateManager.run();
    }
}
