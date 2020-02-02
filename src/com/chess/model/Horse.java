package com.chess.model;
public class Horse extends Piece {

	public Horse (int x, int y) {
		super  (x, y);
	}

	public Horse (boolean flag) {
		super (flag);
	}

	public boolean canMoveToThisPosition (Piece position) {
		boolean flag = false;
		int xDiff = difference (x, position.x);
		int yDiff = difference (y, position.y);
		if ((xDiff == 1 && yDiff == 2) || (xDiff == 2 && yDiff == 1))
			flag = true;
		return flag;
	}
}
