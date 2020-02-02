package com.chess.model;
public class Soldier extends Piece {

	public Soldier (int x, int y) {
		super (x, y);
	}

	public Soldier (boolean flag) {
		super (flag);
	}

	public boolean canMoveToThisPosition (Piece targetPosition) {
		boolean flag = false;
		if ((x == targetPosition.x) && ((y + 1) == targetPosition.y)) {
			flag = true;
		}
		return flag;
	}

}