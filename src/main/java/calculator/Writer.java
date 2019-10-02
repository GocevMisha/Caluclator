package calculator;

import java.io.PrintStream;

public class Writer {

    private PrintStream printStream;

    
    /** 
     * @param printStream
     * @return 
     */
    public Writer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printRules() {
        printStream.println("Welcome to the ConsoleCalculator!\n" +
                "You can do here simple math operations:\n" +
                "For sum insert `+`\n" +
                "For subtraction insert `-`\n" +
                "For multiplication insert `*`\n" +
                "For division insert `/`\n" +
                "For exponentiation insert `^`\n" +
                "For radical insert `v` and next operand=0\n");
    }

    public void printCommands() {
        printStream.print("For starting an operation with this result insert `CONT`\n" +
                "For creating new operation insert `NEW`\n" +
                "For finishing the work insert `END`\n" +
                "Insert command: ");
    }

    public void printInsertOperand() {
        printStream.print("Insert operand: ");
    }

    public void printInsertOperation() {
        printStream.print("Insert operation: ");
    }

    public void printIncorrectOperation() {
        printStream.println("You entered a wrong operation. Try again!");
    }

    public void printIncorrectCommand() {
        printStream.println("You entered a wrong command. Try again!");
    }

    public void printIncorrectOperand() {
        printStream.println("You entered a wrong operand. Try again!");
    }

    public void printDivideByZeroException() {
        printStream.println("You can't divide by zero.");
    }

    public void printGoodbye() {
        printStream.println("Goodbye!");
    }

    
    /** 
     * @param result
     */
    public void printResult(double result) {
        printStream.println("Your result: " + result);
    }
}