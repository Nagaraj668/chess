package com.chess.model;
public interface SquareFunctions {

	public Piece whichPiece ();
	public boolean canAttack (Square square);
	public void attack (Square square);
	public void place (Square square);
	public boolean isEmptySquare ();

}