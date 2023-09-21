package projava;

public class SwitchSample {
    public static void main(String[] args) {
        var a = 5;
        switch (a) {
            case 1:
            case 2:
                System.out.println("one-two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}
