package projava;

public class LoopEx {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 3){
                System.out.println("skip");
                continue;
            }
            System.out.println(i);
        }
    }
}
