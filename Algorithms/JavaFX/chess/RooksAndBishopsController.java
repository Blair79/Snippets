package chess;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author carl
 *
 */
public class RooksAndBishopsController {

	private final Logger log = Logger.getLogger("RooksAndBishopsController");

	/*
	 * private final int NUM_ROWS = 8; private final int NUM_COLS = 8; private
	 * final double PADDING = 40;
	 */
	@FXML
	VBox vbox;

	@FXML
	Pane boardPane; // contains circle and rectangleGroup

	@FXML
	Circle circle;
	@FXML
	Circle leavingCircle; // visual cue on previous space

	@FXML
	Group rectangleGroup;

	//
	// bottom row
	//
	@FXML
	Pane row0;
	@FXML
	Rectangle sq0_0;
	@FXML
	Rectangle sq1_0;
	@FXML
	Rectangle sq2_0;
	@FXML
	Rectangle sq3_0;
	@FXML
	Rectangle sq4_0;
	@FXML
	Rectangle sq5_0;
	@FXML
	Rectangle sq6_0;
	@FXML
	Rectangle sq7_0;

	//
	// 2nd from bottom
	//
	@FXML
	Pane row1;
	@FXML
	Rectangle sq0_1;
	@FXML
	Rectangle sq1_1;
	@FXML
	Rectangle sq2_1;
	@FXML
	Rectangle sq3_1;
	@FXML
	Rectangle sq4_1;
	@FXML
	Rectangle sq5_1;
	@FXML
	Rectangle sq6_1;
	@FXML
	Rectangle sq7_1;

	//
	// 3rd from bottom
	//
	@FXML
	Pane row2;
	@FXML
	Rectangle sq0_2;
	@FXML
	Rectangle sq1_2;
	@FXML
	Rectangle sq2_2;
	@FXML
	Rectangle sq3_2;
	@FXML
	Rectangle sq4_2;
	@FXML
	Rectangle sq5_2;
	@FXML
	Rectangle sq6_2;
	@FXML
	Rectangle sq7_2;

	//
	// 4th from bottom
	//
	@FXML
	Pane row3;
	@FXML
	Rectangle sq0_3;
	@FXML
	Rectangle sq1_3;
	@FXML
	Rectangle sq2_3;
	@FXML
	Rectangle sq3_3;
	@FXML
	Rectangle sq4_3;
	@FXML
	Rectangle sq5_3;
	@FXML
	Rectangle sq6_3;
	@FXML
	Rectangle sq7_3;

	//
	// 4th from top
	//
	@FXML
	Pane row4;
	@FXML
	Rectangle sq0_4;
	@FXML
	Rectangle sq1_4;
	@FXML
	Rectangle sq2_4;
	@FXML
	Rectangle sq3_4;
	@FXML
	Rectangle sq4_4;
	@FXML
	Rectangle sq5_4;
	@FXML
	Rectangle sq6_4;
	@FXML
	Rectangle sq7_4;

	//
	// 3rd from top
	//
	@FXML
	Pane row5;
	@FXML
	Rectangle sq0_5;
	@FXML
	Rectangle sq1_5;
	@FXML
	Rectangle sq2_5;
	@FXML
	Rectangle sq3_5;
	@FXML
	Rectangle sq4_5;
	@FXML
	Rectangle sq5_5;
	@FXML
	Rectangle sq6_5;
	@FXML
	Rectangle sq7_5;

	//
	// 2nd from top
	//
	@FXML
	Pane row6;
	@FXML
	Rectangle sq0_6;
	@FXML
	Rectangle sq1_6;
	@FXML
	Rectangle sq2_6;
	@FXML
	Rectangle sq3_6;
	@FXML
	Rectangle sq4_6;
	@FXML
	Rectangle sq5_6;
	@FXML
	Rectangle sq6_6;
	@FXML
	Rectangle sq7_6;

	//
	// top row
	//
	@FXML
	Pane row7;
	@FXML
	Rectangle sq0_7;
	@FXML
	Rectangle sq1_7;
	@FXML
	Rectangle sq2_7;
	@FXML
	Rectangle sq3_7;
	@FXML
	Rectangle sq4_7;
	@FXML
	Rectangle sq5_7;
	@FXML
	Rectangle sq6_7;
	@FXML
	Rectangle sq7_7;

	private final List<Pane> panes = new ArrayList<>();

	@FXML
	public void initialize() {

		leavingCircle.setOpacity(0.0d);

		panes.add(row0);
		panes.add(row1);
		panes.add(row2);
		panes.add(row3);
		panes.add(row4);
		panes.add(row5);
		panes.add(row6);
		panes.add(row7);

		boardPane.addEventFilter(MouseEvent.MOUSE_EXITED, this::leaveBoard);
		boardPane.addEventFilter(MouseEvent.MOUSE_RELEASED, this::checkReleaseOutOfBoard);

		vbox.setMaxWidth(800.0d);
	}

	private final InnerShadow shadow = new InnerShadow();

	private Rectangle currRect;

	private Point2D offset = new Point2D(0.0d, 0.0d);
	private boolean movingPiece = false;

	public void checkReleaseOutOfBoard(MouseEvent evt) {
		Point2D mousePoint_s = new Point2D(evt.getSceneX(), evt.getSceneY());
		if (!inBoard(mousePoint_s)) {
			leaveBoard(evt);
			evt.consume();
		}
	}

	public void leaveBoard(MouseEvent evt) {
		if (movingPiece) {

			final Timeline timeline = new Timeline();

			offset = new Point2D(0.0d, 0.0d);
			movingPiece = false;

			timeline.getKeyFrames().add(new KeyFrame(Duration.millis(200),
					new KeyValue(circle.layoutXProperty(), leavingCircle.getLayoutX()),
					new KeyValue(circle.layoutYProperty(), leavingCircle.getLayoutY()),
					new KeyValue(circle.opacityProperty(), 1.0d), new KeyValue(leavingCircle.opacityProperty(), 0.0d)));
			timeline.play();
		}
	}

	@FXML
	public void startMovingPiece(MouseEvent evt) {
		circle.setOpacity(0.4d);
		offset = new Point2D(evt.getX(), evt.getY());

		leavingCircle.setOpacity(1.0d);
		leavingCircle.setLayoutX(circle.getLayoutX());
		leavingCircle.setLayoutY(circle.getLayoutY());

		movingPiece = true;
	}

	@FXML
	public void movePiece(MouseEvent evt) {

		Point2D mousePoint = new Point2D(evt.getX(), evt.getY());
		Point2D mousePoint_s = new Point2D(evt.getSceneX(), evt.getSceneY());

		if (!inBoard(mousePoint_s)) {
			return; // don't relocate() b/c will resize Pane
		}

		Point2D mousePoint_p = circle.localToParent(mousePoint);
		circle.relocate(mousePoint_p.getX() - offset.getX(), mousePoint_p.getY() - offset.getY());
	}

	private boolean inBoard(Point2D pt) {
		Point2D panePt = boardPane.sceneToLocal(pt);
		return panePt.getX() - offset.getX() >= 0.0d && panePt.getY() - offset.getY() >= 0.0d
				&& panePt.getX() <= boardPane.getWidth() && panePt.getY() <= boardPane.getHeight();
	}

	@FXML
	public void finishMovingPiece(MouseEvent evt) {

		offset = new Point2D(0.0d, 0.0d);

		Point2D mousePoint = new Point2D(evt.getX(), evt.getY());
		Point2D mousePointScene = circle.localToScene(mousePoint);

		Rectangle r = pickRectangle(mousePointScene.getX(), mousePointScene.getY());

		final Timeline timeline = new Timeline();
		timeline.setCycleCount(1);
		timeline.setAutoReverse(false);

		if (r != null) {
			if (log.isLoggable(Level.FINE)) {
				log.fine("[FINISH] r=" + r.getId());
			}

			Point2D rectScene = r.localToScene(r.getX(), r.getY());
			Point2D parent = boardPane.sceneToLocal(rectScene.getX(), rectScene.getY());

			timeline.getKeyFrames()
					.add(new KeyFrame(Duration.millis(100), new KeyValue(circle.layoutXProperty(), parent.getX()),
							new KeyValue(circle.layoutYProperty(), parent.getY()),
							new KeyValue(circle.opacityProperty(), 1.0d),
							new KeyValue(leavingCircle.opacityProperty(), 0.0d)));

		} else {

			timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), new KeyValue(circle.opacityProperty(), 1.0d),
					new KeyValue(leavingCircle.opacityProperty(), 0.0d)));
		}

		timeline.play();

		movingPiece = false;
	}

	public void mouseMoved(MouseEvent evt) {

		Rectangle r = pickRectangle(evt);

		if (r == null) {

			if (currRect != null) {
				// deselect previous
				currRect.setEffect(null);
			}

			currRect = null;
			return; // might be out of area but w/i scene
		}

		if (r != currRect) {

			if (currRect != null) {
				// deselect previous
				currRect.setEffect(null);
			}

			currRect = r;

			if (log.isLoggable(Level.FINE)) {
				log.fine("[MOVED] in " + currRect.getId());
			}

			if (currRect != null) { // new selection
				currRect.setEffect(shadow);
			}
		}
	}

	private Rectangle pickRectangle(MouseEvent evt) {
		return pickRectangle(evt.getSceneX(), evt.getSceneY());
	}

	private Rectangle pickRectangle(double sceneX, double sceneY) {
		Rectangle pickedRectangle = null;
		for (Pane row : panes) {

			//
			// getX/Y == getSceneX/Y because handler registerd on Scene and
			// not node
			//

			Point2D mousePoint = new Point2D(sceneX, sceneY);
			Point2D mpLocal = row.sceneToLocal(mousePoint);

			if (row.contains(mpLocal)) {
				if (log.isLoggable(Level.FINEST)) {
					log.finest("[PICK] selected row=" + row.getId());
				}

				for (Node cell : row.getChildrenUnmodifiable()) {

					Point2D mpLocalCell = cell.sceneToLocal(mousePoint);

					if (cell.contains(mpLocalCell)) {
						if (log.isLoggable(Level.FINEST)) {
							log.finest("[PICK] selected cell=" + cell.getId());
						}
						pickedRectangle = (Rectangle) cell;
						break;
					}
				}
				break;
			}
		}
		return pickedRectangle;
	}
}