package projava;

import java.util.regex.Pattern;

public class judge {
    public static void main(String[] args) {

        String input = "hlJ3veGneednevlZHZfF";
        boolean typicalPattern = Pattern.compile("^[a-zA-Z0-9]{0,20}$")
                                                 .matcher(input).matches();

        boolean overLength = Pattern.compile("^.{20,}").matcher(input).matches();
        boolean containsNonAscii = Pattern.compile("[^a-zA-Z0-9]").matcher(input).find();
        boolean isEmpty = Pattern.compile("^$").matcher(input).matches();

        if (isEmpty) {
            System.out.println("入力してください。");
        } else if (typicalPattern) {
            System.out.println("OK");
        } else if (overLength) {
            System.out.println("20字以内で入力してください。");
        } else if (containsNonAscii) {
            System.out.println("半角英数字で入力してください。");
        } else {
            System.out.println("NG");
        }
    }
}
