package projava;

public class LoopSample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                System.out.println("end");
                break;
            }
            System.out.println(i);
        }
    }
}
