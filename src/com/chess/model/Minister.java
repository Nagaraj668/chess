package com.chess.model;
public class Minister extends Piece {

	public Minister (int x, int y) {
		super (x, y);
	}

	public Minister (boolean flag) {
		super (flag);
	}

	public boolean canMoveToThisPosition (Piece targetPosition) {
		boolean flag = false;
		if (difference (x, targetPosition.x) == difference (y, targetPosition.y)) {
			flag = true;
		}
		return flag;
	}

}