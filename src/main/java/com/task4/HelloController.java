package com.task4;

import com.task4.module.ConcreteAggregate;
import com.task4.module.Iterator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;

public class HelloController {

    private ConcreteAggregate conaggr;
    private Iterator iter;

    private Timeline time = new Timeline();
    private boolean isPlaying = false;

    @FXML
    private Button startStopButton;

    @FXML
    private ImageView screen;

    @FXML
    private TextField delayField;

    @FXML
    private TextField pathField; // Текстовое поле для ввода пути

    public void initialize() {
        // Настройка временной шкалы
        time.setCycleCount(Timeline.INDEFINITE);
        updateTimeline(1000);

        screen.setPreserveRatio(false);
    }

    // Обработчик события для показа кадров
    private class EvHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            screen.setImage((Image) iter.next());
        }
    }

    @FXML
    public void toggleAnimation() {
        if (isPlaying) {
            time.pause();
            startStopButton.setText("⏹");
        } else {
            startStopButton.setText("▶");
            time.play();
        }
        isPlaying = !isPlaying;
    }

    @FXML
    public void updateDelay() {
        int newDelay = Integer.parseInt(delayField.getText());
        updateTimeline(newDelay);
    }

    private void updateTimeline(int delayMillis) {
        time.stop();
        time.getKeyFrames().clear();
        time.getKeyFrames().add(new KeyFrame(Duration.millis(delayMillis), new EvHandler()));
        if (isPlaying) {
            time.play();
        }
    }

    @FXML
    public void next() {
        screen.setImage((Image) iter.next());
    }

    @FXML
    public void preview() {
        screen.setImage((Image) iter.preview());
    }

    // Новый метод для задания пути к изображениям
    @FXML
    public void setPath() {
        String path = pathField.getText(); // Получаем путь из текстового поля
        conaggr = new ConcreteAggregate(path);
        iter = conaggr.getIterator();
        screen.setImage((Image) iter.next()); // Показать первое изображение
    }
}
