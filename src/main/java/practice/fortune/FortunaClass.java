package practice.fortune;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
//import java.util.Random;

public class FortunaClass {

    public String userName;
    public String fortuneResult;
    ArrayList<String> fortuneList = new ArrayList<>(
            List.of(
                    "大吉",
                    "中吉",
                    "小吉",
                    "半吉",
                    "末吉",
                    "末小吉",
                    "凶",
                    "半凶",
                    "末凶",
                    "大凶"));

    public FortunaClass() {
    }

    public void inputJudge() {
        try (var inputScanner = new Scanner(System.in)) {
            // 不変条件inputScannerはNullではない
            boolean inputCheckResult = false;

            while (! inputCheckResult) {
                System.out.print("あなたのお名前は？(半角英数字で20字以内) ==> ");
                userName = inputScanner.nextLine();
                boolean typicalPattern = Pattern.compile("^[a-zA-Z0-9]{1,20}$")
                                                .matcher(userName)
                                                .matches();
                boolean containsNonAscii = Pattern.compile("[^a-zA-Z0-9]")
                                                  .matcher(userName)
                                                  .find();
                boolean overLength = Pattern.compile("^.{20,}")
                                            .matcher(userName)
                                            .matches();
                boolean inputEmpty = Pattern.compile("^$")
                                            .matcher(userName)
                                            .matches();

                if (inputEmpty) {
                    System.out.println("入力してください。");
                } else if (typicalPattern) {
                    inputCheckResult = true;
                } else if (overLength) {
                    System.out.println("20字以内で入力してください。");
                } else if (containsNonAscii) {
                    System.out.println("半角英数字のみ入力してください。");
                }
                assert userName.matches("^[a-zA-Z0-9]{1,20}$") : "userName is not in the typical pattern.";
            }
        }
    }

    public String getName() {
        assert userName != null : "userName should not be null.";
        return userName;
    }

    public String getFortune() {
//		Random random = new Random();
//		int randomNumber = random.nextInt(10);
        assert fortuneList != null && ! fortuneList.isEmpty() : "fortuneList should not be null or empty.";

        int randomNumber = (int) (Math.random() * 10);
        fortuneResult = fortuneList.get(randomNumber);

        assert fortuneResult != null && fortuneList.contains(fortuneResult) : "fortuneResult should not be null and should be contained in fortuneList.";
        return fortuneResult;
    }
}