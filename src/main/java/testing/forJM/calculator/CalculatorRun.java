package testing.forJM.calculator;

import testing.forJM.calculator.exception.IncorrectDataEntryException;
import testing.forJM.calculator.interfaces.CheckingExpression;
import testing.forJM.calculator.utils.*;

import java.io.*;

import static testing.forJM.calculator.impl.OperationFactory.getOperation;
import static testing.forJM.calculator.utils.ConverterArabicToRoman.convertArabicToRoman;


public class CalculatorRun {

    public static void main(String[] args) {

        try {
            calculate();
        } catch (IncorrectDataEntryException e) {
            e.printStackTrace();
        }
    }

    private static void calculate() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] expression;
            String inputString;
            while (true) {
                System.out.println("\nInput: \n");
                inputString = bufferedReader.readLine();
                if (inputString.equalsIgnoreCase("exit")) {
                    break;
                }
                CheckingExpression checkExpression = new CheckingInputString(inputString);
                if (checkExpression.isValidExpression()) {
                    expression = inputString.split(" ");
                    if (checkExpression.isRomanNumeric()) {
                        calculateRomanNumbers(expression);
                    } else {
                        calculateArabicNumbers(expression);
                    }
                } else {
                    throw new IncorrectDataEntryException("Invalid input:\u001B[1m\"" + inputString + "\"\u001B[0m!");
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateArabicNumbers(String[] expression) {
        int x;
        int y;
        x = Integer.parseInt(expression[0]);
        y = Integer.parseInt(expression[2]);
        System.out.println("\nOutput: \n");
        System.out.println(getOperation(expression[1]).result(x, y));
    }

    private static void calculateRomanNumbers(String[] expression) {
        int x;
        int y;
        RomanNumeric romanNumeric;
        romanNumeric = RomanNumeric.valueOf(expression[0]);
        x = romanNumeric.getArabicNumerals();
        romanNumeric = RomanNumeric.valueOf(expression[2]);
        y = romanNumeric.getArabicNumerals();
        System.out.println("\nOutput: \n");
        int result = getOperation(expression[1]).result(x, y);
        System.out.println(convertArabicToRoman(result));
    }

}
