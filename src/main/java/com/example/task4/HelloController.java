package com.example.task4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ImageCollection imgs = new ImageCollection("pic");
    public Iterator iter_main = imgs.getIterator();


    public ImageView imageCurr;

    public Timeline timeline = new Timeline();


    public void play(ActionEvent actionEvent) {
        timeline.play();
    }




    public void uploadImage(ActionEvent actionEvent) {
        imageCurr.setImage(new Image("/pic1.jpg"));
    }


    public void handle (ActionEvent t) {
        if (iter_main.hasNext()){
            Image name = (Image) iter_main.next();
            imageCurr.setImage(name);
        }
    }

    public void prev(ActionEvent actionEvent) {
        if (iter_main.hasPrevious()){
            Image name = (Image) iter_main.preview();
            imageCurr.setImage(name);
        }
    }




    public void stop(ActionEvent actionEvent) {
        timeline.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(new Duration(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (iter_main.hasNext()){
                    Image name = (Image) iter_main.next();
                    imageCurr.setImage(name);
                }
            }
        }));
    }
}
