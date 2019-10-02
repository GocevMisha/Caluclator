package calculator;

import calculator.exception.DivideByZeroException;

import static java.lang.Math.pow;

public class Executor {

    
    /** 
     * @param x
     * @param y
     * @param operation
     * @return double
     * @throws DivideByZeroException
     */
    public static double execute(double x, double y, char operation) throws DivideByZeroException {
        switch (operation) {
            case '+': {
                return getSum(x, y);
            }
            case '-': {
                return getSubtraction(x, y);
            }
            case '*': {
                return getMultiplication(x, y);
            }
            case '/': {
                return getDivision(x, y);
            }
            case '^': {
                return getExponentiation(x, y);
            }
            case 'v': {
                return getRadical(x);
            }
            case 'l':{
                return getLogarifm(x);
            }
        }
        throw new IllegalArgumentException("It's impossible.");
    }

    
    /** 
     * @param x
     * @param y
     * @return double
     */
    private static double getSum(double x, double y) {
        return x + y;
    }

    
    /** 
     * @param x
     * @param y
     * @return double
     */
    private static double getSubtraction(double x, double y) {
        return x - y;
    }

    
    /** 
     * @param x
     * @param y
     * @return double
     */
    private static double getMultiplication(double x, double y) {
        return x * y;
    }

    
    /** 
     * @param x
     * @param y
     * @return double
     * @throws DivideByZeroException
     */
    private static double getDivision(double x, double y) throws DivideByZeroException {
        if (y == 0) {
            throw new DivideByZeroException();
        }
        return x / y;
    }
   
    
    /** 
     * @param x
     * @param y
     * @return double
     */
    private static double getExponentiation(double x, double y) {
        if (x == 0 && y < 0) {
            throw new DivideByZeroException();
        }
        return pow(x, y);
    }

    private static double getRadical(double x){
        if (x == 0) {
            throw new DivideByZeroException();
        }
        return Math.sqrt(x);
    }
    private static double getLogarifm(double x){
        if (x == 0) {
            throw new DivideByZeroException();
        }
        return Math.log(x);
    }

}
