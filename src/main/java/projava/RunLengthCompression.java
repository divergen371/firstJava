package projava;

public class RunLengthCompression {
    public static void main(String[] args) {
        final var COUNT_BASE = -1;
        var data = "abbcccbaaaabccccccccccccddd";

        var count = COUNT_BASE;
        char prev = 0;
        var builder = new StringBuilder();
        for (var ch : data.toCharArray()) {
            if (prev == ch) {
                count++;
                if (count == 9) {
                    builder.append('9');
                    count = COUNT_BASE;
                    prev = 0;
                }
            } else {
                if (count >= 0) {
                    builder.append((char) ('0' + count));
                    count = COUNT_BASE;
                }
                builder.append(ch);
                prev = ch;
            }
        }
       if (count >= 0) {
           builder.append((char) ('0' + count));
       }
       var result = builder.toString();
        System.out.println(data);
        System.out.println(result);
    }
}
