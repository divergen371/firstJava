package practice.fortune;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FortunaClass {
    private String userName;
    private String fortuneResult;
    private final ArrayList<String> fortuneList = new ArrayList<>(
            List.of(
                    "大吉", "中吉", "小吉", "半吉", "末吉",
                    "末小吉", "凶", "半凶", "末凶", "大凶"));

    public void inputJudge() {
        try (var inputScanner = new Scanner(System.in)) {
            boolean inputCheckResult = false;
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{1,20}$");

            while (!inputCheckResult) {
                System.out.print("あなたのお名前は？(半角英数字で20字以内) ==> ");
                userName = inputScanner.nextLine();

                if (userName.isEmpty()) {
                    System.out.println("入力してください。");
                } else if (!pattern.matcher(userName).matches()) {
                    System.out.println("半角英数字のみで20字以内で入力してください。");
                } else {
                    inputCheckResult = true;
                }
            }
        }
    }

    public String getName() {
        return userName;
    }

    public String getFortune() {
        Random random = new Random();
        int randomNumber = random.nextInt(fortuneList.size());
        fortuneResult = fortuneList.get(randomNumber);
        return fortuneResult;
    }
}