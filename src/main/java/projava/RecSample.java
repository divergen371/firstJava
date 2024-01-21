package projava;

public class RecSample {
    public static void main(String[] args) {
        loop(0);
    }

    private static void loop(int i) {
        if (i >= 5) {
            return;
        }
        System.out.println(i);
        loop(i + 1);
    }
}
