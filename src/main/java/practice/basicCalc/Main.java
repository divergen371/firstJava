package practice.basicCalc;

class Main {
	public static void main(String[] args) {
		CalculatorClass calculator = new CalculatorClass();

		System.out.println("基本的な計算機プログラムです。");
		calculator.inputValue();
		calculator.inputOperator();
		calculator.showCalculationResult();
	}
}
