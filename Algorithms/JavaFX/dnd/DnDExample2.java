package dnd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DnDExample2 extends Application {

	private final int stageWidth = 1000;
	private final int stageHeight = 600;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("DnDExample2.fxml"));
		primaryStage.setTitle("Drag and Drop funny stuff");
		scene = new Scene(root, stageWidth, stageHeight);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}