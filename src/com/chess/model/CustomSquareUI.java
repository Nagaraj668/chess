package com.chess.model;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class CustomSquareUI extends JButton {

	private static final String RESOURCES_PATH = "resources/";
	private static final String WHITE = "WHITE";
	private static final String BLACK = "BLACK";
	private static final String WHITE_ICONS_PATH = "white_pieces/";
	private static final String BLACK_ICONS_PATH  = "black_pieces/";
	private String iconPath;
	private Square square;
	private Color previousColor;

	public CustomSquareUI () {
		setFocusPainted(false);
	}

	public void setIconType (String iconColor) {
		if (iconColor.equals (WHITE)) {
			iconPath = WHITE_ICONS_PATH;
		} else {
			iconPath = BLACK_ICONS_PATH;
		}
	}

	public void loadIcon (String iconName) {
		Image img = getScaledImage((new ImageIcon (RESOURCES_PATH + iconPath + iconName)).getImage (), 30, 30);
		ImageIcon icon = new ImageIcon (img);
		setIcon (icon);
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage (w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics ();
		g2.setRenderingHint (RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage (srcImg, 0, 0, w, h, null);
		g2.dispose ();
    		return resizedImg;
	}

	public Square getSquare () {
		return this.square;
	}

	public void setSquare (Square square) {
		this.square = square;
		Piece piece = square.whichPiece ();
		if (piece != null) {
			if (piece.isBlackPiece ()) {
				setIconType (BLACK);
			} else {
				setIconType (WHITE);
			}
			loadIcon (piece.getClassName () + ".png");
		} else {
			setIcon (null);
		}
	}

	public void highlight () {
		previousColor = getBackground ();
		setBackground (Color.YELLOW);
	}

	public void deHighlight () {
		setBackground (previousColor);
	}

	public void validateMove (Board board, CustomSquareUI squareUI) {
		Square targetSquare = squareUI.getSquare ();
		boolean flag = board.validateMovement (targetSquare);
		if (flag) {
			board.performMovement (square, targetSquare);
		}
	}
}