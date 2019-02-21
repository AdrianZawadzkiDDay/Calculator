package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;

    private double number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Model model = new Model();

    // obsługuje zdarzenia jeśli naciśniemy liczby: czyta wartość danej liczby
    //  np. <Button text="7" .../> odczyta jako 7
    @FXML
    private void processNumber(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    // obsuguje zdarzenia jeśli naciśniemy +,-,/ lub *
    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!value.equals("=")) {
            operator = value;
            number1 = Double.parseDouble(output.getText());
            output.setText("");
        }
        else {
            output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    // czyszczenie pola tekstowego, wykonywanie działania od początku
    @FXML
    private void clearOperator(ActionEvent event){
        start = true;
        number1 = 0;
        String operator = "";
        output.setText("");
        model = new Model();
    }
}
