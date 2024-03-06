package practice.basicCalc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorClass {
    int firstValue, secondValue;
    String  operator;
    double  calcResult;
    Scanner inputScanner = new Scanner(System.in);

    public void inputValue() {
        //		Scanner inputScanner = new Scanner(System.in);
        boolean isValidInput = false;

        while (! isValidInput) {
            try {
                System.out.println("第一数値を入力してください");
                firstValue = inputScanner.nextInt();
                System.out.println("第二数値を入力してください");
                secondValue = inputScanner.nextInt();
                isValidInput = true;
                inputScanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("整数ではない値が入力されました。");
                inputScanner.nextLine();
            }
        }
    }

    public void inputOperator() {
        //		Scanner inputScanner = new Scanner(System.in);
        boolean isValidOperator = false;
        while (! isValidOperator) {
            System.out.println("演算子(+,-,*,/)を入力してください");
            operator = inputScanner.nextLine();
            isValidOperator = operatorChecker(operator, isValidOperator);

        }
        inputScanner.close();
    }

    public boolean operatorChecker(String operator, boolean validFlag) {
        try {
            if (! operator.matches("[+\\-*/]")) {
                throw new IllegalArgumentException("演算子以外の文字は入力しないでください");
            } else {
                validFlag = true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("エラー: " + e.getMessage());
        }
        return validFlag;
    }

    public void showCalculationResult() {
        try {
            calculator(firstValue, secondValue, operator);
            System.out.println("計算結果" + calcResult);
        } catch (ArithmeticException e) {
            System.out.println("0で除算は出来ません");
            System.out.println("計算機プログラムを終了します");
        }
    }

    public void calculator(int firstValue, int secondValue, String operator)
            throws ArithmeticException {
        if (operator.matches("[+]")) {
            calcResult = firstValue + secondValue;
        } else if (operator.matches("[-]")) {
            calcResult = firstValue - secondValue;
        } else if (operator.matches("[*]")) {
            calcResult = firstValue * secondValue;
        } else if (operator.matches("[/]")) {
            calcResult = firstValue / secondValue;
        }
    }

}