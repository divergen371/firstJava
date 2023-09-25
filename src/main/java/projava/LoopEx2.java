package projava;

public class LoopEx2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 3 || i == 5) {
                System.out.println("skip");
                continue;
            }
            System.out.println(i);
        }
    }
}
