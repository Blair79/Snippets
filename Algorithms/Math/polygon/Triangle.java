package polygon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Triangle extends Application {
	@Override
	public void start(Stage stage) {
		
		int verschieb=20;
		
		int px1 = 50;
		int py1 = 50;

		int px2 = 150;
		int py2 = 100;

		int px3 = 75;
		int py3 = 200;
		Group root = new Group();
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);

		Group g = new Group();

		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(
				new Double[] { (double) px1, (double) py1, (double) px2, (double) py2, (double) px3, (double) py3 });
		polygon.setFill(Color.BLUE);

		Text a = new Text(px1, py1, "A" + px1 + " " + py1);
		Line ab = new Line(px1, py1 - verschieb, px2, py2 - verschieb);

		Text b = new Text(px2, py2, "B" + px2 + " " + py2);
		Line bc = new Line(px2 + verschieb, py2 + verschieb, px3 + verschieb, py3 + verschieb);

		Text c = new Text(px3, py3, "C" + px3 + " " + py3);
		Line ca = new Line(px3 - verschieb, py3 + verschieb, px1 - verschieb, py1 + verschieb);

		g.getChildren().addAll(polygon, a, ab, b, bc, c, ca);

		scene.setRoot(g);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}