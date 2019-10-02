package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {

    private Scanner scanner;
    private final List<Character> operations = Arrays.asList('+', '-', '*', '/', '^', 'v');
    private final List<String> commands = Arrays.asList("CONT", "NEW", "END");

    
    /** 
     * @param scanner
     * @return 
     */
    public Reader(Scanner scanner) {
        this.scanner = scanner;
    }

    
    /** 
     * @return char
     * @throws IllegalArgumentException
     */
    public char readOperation() throws IllegalArgumentException {
        String input = scanner.nextLine().trim();
        if (input.length() != 1 || !operations.contains(input.charAt(0))) {
            throw new IllegalArgumentException(input);
        }
        return input.charAt(0);
    }

    
    /** 
     * @return double
     * @throws NumberFormatException
     */
    public double readOperand() throws NumberFormatException {
        String input = scanner.nextLine().trim();
        return Double.parseDouble(input);
    }

    
    /** 
     * @return String
     * @throws IllegalArgumentException
     */
    public String readCommand() throws IllegalArgumentException {
        String input = scanner.nextLine().trim();
        if (!commands.contains(input)) {
            throw new IllegalArgumentException(input);
        }
        return input;
    }
}
