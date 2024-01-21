package projava;

import java.util.ArrayList;
import java.util.List;

public class StreamSample2 {
    public static void main(String[] args) {
        var data = List.of("yamamoto", "kis", "sugiyama" , "hogeo", "piyop");
        var result = (int) data.stream().filter(s -> s.length() >= 5).count();
        System.out.println(result);

        var newList = new ArrayList<String>();
        var  fiveCount = 0;
        for (String s : data) {
            if (s.length() == 5) {
                newList.add(s);
                fiveCount += 1;
            }
            if (s.length() == 5 && s.contains("p")) {
                System.out.println("すべての文字列にpが含まれています");
            }
        }


        System.out.println(fiveCount);
        System.out.println(newList);
    }
}
