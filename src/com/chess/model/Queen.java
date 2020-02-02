package com.chess.model;
public class Queen extends Piece {

	public Queen (int x, int y) {
		super (x, y);
	}

	public Queen (boolean flag) {
		super (flag);
	}

	public boolean canMoveToThisPosition (Piece targetPosition) {
		boolean flag = false;
		if (x == targetPosition.x || y == targetPosition.y) {
			flag = true;
		} else if (difference (x, targetPosition.x) == difference (y, targetPosition.y)) {
			flag = true;
		}
		return flag;
	}

}