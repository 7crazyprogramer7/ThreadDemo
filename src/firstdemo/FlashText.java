package firstdemo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText extends Application {

    private String text = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();
        Label labtext = new Label("aaaa");
        stackPane.getChildren().add(labtext);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (labtext.getText().trim().length() == 0) {
                            text = "welcome";
                        } else {
                            text = "";
                        }

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(text);
                                labtext.setText(text);
                            }
                        });

                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        }).start();

        Scene scene = new Scene(stackPane, 200, 50);
        primaryStage.setTitle("FlashText");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
