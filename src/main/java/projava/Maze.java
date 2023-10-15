package projava;

import java.io.IOException;

public class Maze {
    public static void main(String[] args) throws IOException {
        record Position(int x, int y) {
        }
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
        };
        var current = new Position(1, 3);
        var upper = false;
        var goal = new Position(4, 1);
        for (; ; ) {
            for (int y = current.y() - 2; y <= current.y() + 2; y++) {
                for (int x = current.x() - 2; x < current.x() + 2; x++) {
                    if (y < 0 || y >= map.length || x < 0 || x >= map[y].length) {
                        System.out.print("#");
                    } else if (x == current.x() && y == current.y()) {
                        System.out.print(upper ? "O" : "o");
                    } else if (map[y][x] == 1) {
                        System.out.print("*");

                    } else if (y == goal.y() && x == goal.x()) {
                        System.out.print("G");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            if (current.equals(goal)) {
                System.out.println("GOAL!!");
                break;
            }
            int ch = System.in.read();
            if (ch == '\n') continue;
            var next = switch (ch) {
                case 'h' -> new Position(current.x() - 1, current.y());
                case 'u' -> new Position(current.x(), current.y() - 1);
                case 'j' -> new Position(current.x() + 1, current.y());
                case 'n' -> new Position(current.x(), current.y() + 1);
                default -> current;
            };
            if (map[next.y()][next.x()] == 0) {
                if (!current.equals(next)) {
                    upper = !upper;
                }
                current = next;
            }
            System.in.read();
        }
    }
}
