package co.edu.uniquindio.bookYourStay.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookYourStayApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(BookYourStayApp.class.getResource("/inicio.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("BookYourStay");
        //stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(BookYourStayApp.class, args);
    }
}
