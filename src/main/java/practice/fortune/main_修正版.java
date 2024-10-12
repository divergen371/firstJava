package practice.fortune;

class Main {
    public static void main(String[] args) {
        FortunaClass fortuneSlip = new FortunaClass();
        System.out.println("おみくじシステムを開始します。よろしくお願いします。");
        fortuneSlip.inputJudge();
        System.out.println(STR."\{fortuneSlip.getName()}さんですね！こんにちは!!");
        System.out.println(STR."\{fortuneSlip.getName()}さんの今日の運勢は\{fortuneSlip.getFortune()}です。");
        System.out.println("よい一日を!!");
        System.out.println("おみくじシステムを終了します!!");
    }
}