package projava;

public class InstanceMethodSample {
    public static void main(String[] args) {
        var kis = new Student("Kis", 80, 70);
        var a = kis.average();
//        System.out.printf("平均点は%d点です%n", a);
        kis.showResult();
        int max = kis.maxScore();
        System.out.printf("最高点は%d点です%n", max);
    }


    record Student(String name, int englishScore, int mathScore) {
        int average() {
            return (this.englishScore + this.mathScore) / 2;
        }

        void showResult() {
            var a = this.average();
            System.out.printf("%sさんの平均点は%d点です%n", this.name, a);
        }

        public int maxScore() {
            return Math.max(englishScore, mathScore);
        }
    }
}
