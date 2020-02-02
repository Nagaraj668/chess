package com.chess.model;


public class King extends Piece {

	public King (int x, int y) {
		super (x, y);
	}

	public King (boolean flag) {
		super (flag);
	}

	public boolean canMoveToThisPosition (Piece targetPosition) {
		boolean flag = false;
		if (x == targetPosition.x && difference (y, targetPosition.y) == 1 || y == targetPosition.y && difference (x, targetPosition.x) == 1) {
			flag = true;
		} else if (difference (x, targetPosition.x) == difference (y, targetPosition.y)) {
			flag = true;
		}
		return flag;
	}


}