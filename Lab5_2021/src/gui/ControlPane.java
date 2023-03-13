package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox {

	private Text gameText = new Text();
	private Button newGameButton = new Button();
	private Button secureModeButton = new Button();
	private MineSweeperPane mineSweeperPane;

	public ControlPane(MineSweeperPane mineSweeperPane) {
		setMineSweerPane(mineSweeperPane);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		initializeGameText();
		initializeNewGameButton();
		initializeSecureModeButton();
		this.getChildren().add(gameText);
		this.getChildren().add(newGameButton);
		this.getChildren().add(secureModeButton);
	}

	public void initializeGameText() {
		String text = "Tiles left : " + GameLogic.getInstance().getTileCount();
		this.gameText.setText(text);
		this.gameText.setFont(Font.font("Tahoma", 35));
	}

	public void updateGameText(String text) {
		this.gameText.setText(text);
	}

	public void initializeNewGameButton() {
		this.newGameButton.setText("New Game");
		this.newGameButton.setPrefWidth(100);
		this.newGameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				newGameButtonHandler();
			}
		});
	}

	public void initializeSecureModeButton() {
		this.secureModeButton.setText("Secure mode: OFF");
		this.secureModeButton.setPrefWidth(150);
		this.secureModeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				secureModeButtonHandler();
			}
		});
	}

	public void newGameButtonHandler() {
		GameLogic.getInstance().newGame();
		this.secureModeButton.setText("Secure mode : OFF");
		this.gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());
		for (MineSweeperSquare sq : mineSweeperPane.getAllCells()) {
			sq.initializeCellColor();
		}
	}

	public void secureModeButtonHandler() {
		GameLogic.getInstance().toggleSecureMode();
		if (GameLogic.getInstance().isSecureMode()) {
			this.secureModeButton.setText("Secure mode : ON");
		} else {
			this.secureModeButton.setText("Secure mode : OFF");
		}
	}

	public MineSweeperPane getMineSweeperPane() {
		return mineSweeperPane;
	}

	public void setMineSweerPane(MineSweeperPane mineSweeperPane) {
		this.mineSweeperPane = mineSweeperPane;
	}
}

