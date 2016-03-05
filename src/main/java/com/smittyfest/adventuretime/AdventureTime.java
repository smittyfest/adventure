package com.smittyfest.adventuretime;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author smittyfest
 * @since 3/5/16
 */
public class AdventureTime extends Application {
  @Override public void start(Stage stage) throws Exception {
    Scene scene = new Scene(new Group(), 516, 387);
    stage.setScene(scene);
    stage.setTitle("ADVENTURE TIME!!!");
    stage.show();
  }

  public static void main(String [] args) {
    Application.launch(args);
  }
}
