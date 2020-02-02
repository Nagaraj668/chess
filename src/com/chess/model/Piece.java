package com.chess.model;

public abstract class Piece {
	public int x;
	public int y;
	protected boolean blackPiece;
	protected int initialPositionX, initialPositionY;
	private boolean myPiece;

	public Piece (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Piece (boolean flag) {
		this.blackPiece = flag;
	}

	public int getX () {
		return this.x;
	}

	public void setX (int x) {
		this.x = x;
	}

	public int getY () {
		return this.y;
	}

	public void setY (int y) {
		this.y = y;
	}

	public boolean isBlackPiece () {
		return this.blackPiece;
	}

	public int difference (int num1, int num2) {
		int diff = num1 - num2;
		if (diff < 0) {
			diff = diff * (-1);
		}
		return diff;
	}

	public void displayMove () {
		System.out.print("X: "+x+", Y: "+y+"\n");
	}

	public String getClassName () {
		return getClass().getCanonicalName();
	}

	public void setInitialPosition (int x, int y) {
		this.initialPositionX = x;
		this.initialPositionY = y;
	}

	public void setPosition (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setMyPieceFlag (boolean flag) {
		this.myPiece = myPiece;
	}

	public boolean isThisMyPiece () {
		return this.myPiece;
	}

	public abstract boolean canMoveToThisPosition (Piece piece);
}