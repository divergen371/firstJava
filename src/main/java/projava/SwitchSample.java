package projava;

public class SwitchSample {
    public static void main(String[] args) {
        var a = 5;
//        switch (a) {
//            case 1, 2 -> System.out.println("one-two");
//            case 3 -> System.out.println("three");
//            case 4 -> System.out.println("four");
//            case 5 -> System.out.println("five");
//            default -> System.out.println("other");
//        }
        System.out.println(switch (a) {
            case 1, 2 -> "one-two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            default -> "other";
        });
    }
}
