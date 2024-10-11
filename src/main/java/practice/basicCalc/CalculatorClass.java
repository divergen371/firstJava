package practice.basicCalc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorClass {
    int firstValue, secondValue;
    String operator;
    double calcResult;
    Scanner inputScanner = new Scanner(System.in);

    public void inputValue() {
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("第一数値を入力してください");
                firstValue = inputScanner.nextInt();
                System.out.println("第二数値を入力してください");
                secondValue = inputScanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("整数ではない値が入力されました。");
            } finally {
                inputScanner.nextLine(); // Consume the newline
            }
        }
    }

    public void inputOperator() {
        boolean isValidOperator = false;
        while (!isValidOperator) {
            System.out.println("演算子(+,-,*,/)を入力してください");
            operator = inputScanner.nextLine();
            isValidOperator = operatorChecker(operator);
        }
        // Do not close the scanner here if you need it afterward.
    }

    public boolean operatorChecker(String operator) {
        if (!operator.matches("[+\\-*/]")) {
            System.out.println("エラー: 演算子以外の文字は入力しないでください");
            return false;
        }
        return true;
    }

    public void showCalculationResult() {
        try {
            calculator(firstValue, secondValue, operator);
            System.out.println("計算結果: " + calcResult);
        } catch (ArithmeticException e) {
            System.out.println("0で除算は出来ません");
            System.out.println("計算機プログラムを終了します");
        }
    }

    public void calculator(int firstValue, int secondValue, String operator)
            throws ArithmeticException {
        switch (operator) {
            case "+":
                calcResult = firstValue + secondValue;
                break;
            case "-":
                calcResult = firstValue - secondValue;
                break;
            case "*":
                calcResult = firstValue * secondValue;
                break;
            case "/":
                if (secondValue == 0) throw new ArithmeticException();
                calcResult = firstValue / secondValue;
                break;
        }
    }

    // If the scanner needs to be closed it should be done in a controlled manner
    // public void closeScanner() {
    //     if (inputScanner != null) {
    //         inputScanner.close();
    //     }
    // }
}