package com.chess.model;


public class Square implements SquareFunctions {

	private int x;
	private int y;
	private Piece piece;

	public Square (int x, int y, Piece piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
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

	public Piece whichPiece () {
		return this.piece;
	}

	public boolean canAttack (Square square) {
		return false;
	}

	public void attack (Square square) {

	}

	public void place (Square square) {
		piece = square.whichPiece ();
	}

	public boolean isEmptySquare () {
		if (this.piece == null) {
			return true;
		}
		return false;
	}
}