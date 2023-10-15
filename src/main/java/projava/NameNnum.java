package projava;

import java.util.List;

public class NameNnum {
    public static void main(String[] args) {
        var names = List.of("yosuke", "kis", "sugiyama");
        for (int i = 0; i < names.size(); i++) {
            var name = names.get(i);
            System.out.println(name);
        }
    }
}
