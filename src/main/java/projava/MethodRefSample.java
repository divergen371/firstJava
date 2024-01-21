package projava;

import java.util.stream.IntStream;

public class MethodRefSample {
    public static void main(String[] args) {
        IntStream.range(0, 3)
                 .map(x -> twice(x))
                 .forEach(x1 -> System.out.println(x1));
    }

    private static int twice(int x) {
        return x * 2;
    }
}

