package sample;

public class Model {

    // metoda służąca do wykonywania działań
    public double calculate(double number1, double number2, String operator) {

        // przekazuje operator i wybiera rodzaj działania
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0)
                    return 0;

                return (double) ( number1 / (number2));
        }

        System.out.println("Nieprawidłowy operator - " + operator);
        return 0;
    }
}
