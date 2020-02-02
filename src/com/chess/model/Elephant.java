package com.chess.model;
public class Elephant extends Piece {

	public Elephant (int x, int y) {
		super (x, y);
	}

	public Elephant (boolean flag) {
		super (flag);
	}

	public boolean canMoveToThisPosition (Piece targetPosition) {
		boolean flag = false;
		if ((x == targetPosition.x) || (y == targetPosition.y)) {
			flag = true;
		}
		return flag;
	}

}