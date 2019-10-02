package calculator;

import calculator.exception.DivideByZeroException;

public class CalculateManager {
    
    private Reader reader;
    private Writer writer;
    private double answer;
    
    
    /** 
     * @param reader
     * @param writer
     * @return 
     */
    public CalculateManager(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }
    

    public void run() {
        writer.printRules();
        runWithTwoOperand();
    }

    
    /** 
     * @param x
     */
    private void runWithOneOperand(double x) {
        char operation = readOperation();
        double y = readOperand();
        execute(x, y, operation);
        parseCommand(readCommand());
    }

    private void runWithTwoOperand() {
        double x = readOperand();
        runWithOneOperand(x);
    }

    
    /** 
     * @return double
     */
    private double readOperand() {
        writer.printInsertOperand();
        double operand;
        try {
            operand = reader.readOperand();
        } catch (NumberFormatException e) {
            writer.printIncorrectOperand();
            return readOperand();
        }
        return operand;
    }

    
    /** 
     * @return char
     */
    private char readOperation() {
        writer.printInsertOperation();
        char operation;
        try {
            operation = reader.readOperation();
        } catch (IllegalArgumentException e) {
            writer.printIncorrectOperation();
            return readOperation();
        }
        return operation;
    }

    
    /** 
     * @return String
     */
    private String readCommand() {
        writer.printCommands();
        String command;
        try {
            command = reader.readCommand();
        } catch (IllegalArgumentException e) {
            writer.printIncorrectCommand();
            return readCommand();
        }
        return command;
    }

    
    /** 
     * @param x
     * @param y
     * @param operation
     */
    private void execute(double x, double y, char operation) {
        try {
            double ans = Executor.execute(x, y, operation);
            this.answer = ans;
            writer.printResult(ans);
        } catch (DivideByZeroException e) {
            writer.printDivideByZeroException();
        }
    }

    
    /** 
     * @param commandName
     */
    private void parseCommand(String commandName) {
        Command command;
        try {
            command = Command.valueOf(commandName);
        } catch (IllegalArgumentException e) {
            writer.printIncorrectCommand();
            parseCommand(readCommand());
            return;
        }
        switch (command) {
            case CONT: {
                runWithOneOperand(answer);
                return;
            }
            case NEW: {
                runWithTwoOperand();
                return;
            }
            case END: {
                writer.printGoodbye();
            }
         }
    }

    private enum Command {
        CONT(),
        NEW(),
        END()
    }
}
