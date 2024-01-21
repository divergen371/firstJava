package projava;

public class methodSample {
    public static void main(String[] args) {
        var result = twice(5);
        System.out.println(result);
    }

    static int twice(int x) {
        return x * 2;
    }
}
