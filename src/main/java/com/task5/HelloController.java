package com.task5;

import com.task5.module.Builder;
import com.task5.module.ConcreteBuilder;
import com.task5.module.Director;
import com.task5.module.Indicator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane indicatorPane;

    @FXML
    private TextField startField, stopField, measureField;

    private Director director = new Director();

    @FXML
    public void createIndicator() {
        try {
            float start = Float.parseFloat(startField.getText());
            float stop = Float.parseFloat(stopField.getText());
            float measure = Float.parseFloat(measureField.getText());

            if (start >= stop) {
                showAlert("Ошибка", "Начальное значение должно быть меньше конечного!");
                return;
            }

            if (measure < start || measure > stop) {
                showAlert("Ошибка", "Значение выходит за границы диапазона!");
                return;
            }

            indicatorPane.getChildren().clear();

            Builder builder = new ConcreteBuilder();
            Indicator indicator = director.construct(builder, start, stop, measure);

            indicator.show(indicatorPane);
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Введите корректные числовые значения.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
