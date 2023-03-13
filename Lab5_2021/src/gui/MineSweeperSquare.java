package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane{
	
	private boolean isDrawn;
	private Color baseColor;
	private int xPosition,yPosition;
	private final String oURL,oneURL,mineURL,flagURL;

	//Constructor
	public MineSweeperSquare(int x, int y) {
		this.oneURL = "one.png";
		this.oURL = "o.png";
		this.mineURL = "mine.png";
		this.flagURL = "flag.png";
		setXPosition(x);
		setYPosition(y);
		setPrefHeight(100);
		setPrefWidth(100);
		setMinHeight(100);
		setMinWidth(100);
		setBaseColor(Color.MOCCASIN);
		initializeCellColor();
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				onClickHandler();
			}
		});
	}
	
	//Method
	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
	}
	
	private void onClickHandler() {
		if (!GameLogic.getInstance().isGameEnd()) {
			if (!GameLogic.getInstance().isSecureMode()
					&& (GameLogic.getInstance().getBoardState()[xPosition][yPosition] == SquareState.CONCEALED)) {
				if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.ONE) {

					String oneURL_Path = ClassLoader.getSystemResource(this.oneURL).toString();
					Image one = new Image(oneURL_Path);
					draw(one, Color.ORANGE);

				} else if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.NOTHING) {

					String oURL_Path = ClassLoader.getSystemResource(this.oURL).toString();
					Image o = new Image(oURL_Path);
					draw(o, Color.YELLOW);

				} else if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.MINE) {

					String mineURL_Path = ClassLoader.getSystemResource(this.mineURL).toString();
					Image mine = new Image(mineURL_Path);
					draw(mine, Color.RED);
				}

				GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.REVEALED);
			} else if (GameLogic.getInstance().isSecureMode()
					&& (GameLogic.getInstance().getBoardState()[xPosition][yPosition] == SquareState.CONCEALED)) {
				String flagURL_Path = ClassLoader.getSystemResource(this.flagURL).toString();
				Image flag = new Image(flagURL_Path);
				draw(flag, Color.GREEN);
				GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.SECURED);
			}
		}
	}
	
	public void initializeCellColor() {
		BackgroundFill bgFilled = new BackgroundFill(this.getBaseColor(), CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFilled };
		setBackground(new Background(bgFillA));
		setDrawn(false);
	}

	//setter
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}
	
	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}
	
	//getter
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public boolean isDrawn() {
		return isDrawn;
	}
	
	public Color getBaseColor() {
		return baseColor;
	}
	
	public String getOneURL() {
		return oneURL;
	}
	
	public String getoURL() {
		return oURL;
	}
	
	public String getMineURL() {
		return mineURL;
	}
	
	public String getFlagURL() {
		return flagURL;
	}
	
}