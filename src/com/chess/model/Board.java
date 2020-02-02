package com.chess.model;


public class Board {


	private Square[][] squares;

	// mine
	private Elephant leftElephant, rightElephant;
	private Horse leftHorse, rightHorse;
	private Minister leftMinister, rightMinister;
	private King king;
	private Queen queen;
	private Soldier soldier1, soldier2, soldier3, soldier4, soldier5, soldier6, soldier7, soldier8;

	// opponents
	private Elephant opponentLeftElephant, opponentRightElephant;
	private Horse opponentLeftHorse, opponentRightHorse;
	private Minister opponentLeftMinister, opponentRightMinister;
	private King opponentKing;
	private Queen opponentQueen;
	private Soldier opponentSoldier1, opponentSoldier2, opponentSoldier3, 
		opponentSoldier4, opponentSoldier5, opponentSoldier6, opponentSoldier7, opponentSoldier8;

	private boolean blackPieceFlag;

	public void setBlackPieceFlag (boolean flag) {
		this.blackPieceFlag = flag;
	}

	public boolean isBlackPieceFlag () {
		return this.blackPieceFlag;
	}

	public Square[][] getSquares () {
		return this.squares;
	}

	public void updateSquare (int i, int j, Square square) {
		squares[i][j] = square;
	}

	public void initBoard () {
		squares = new Square[8][8];
		initMyPieces ();
		arrangeMyPieces ();
		initOpponentPieces ();
		arrangeOpponentPieces ();
		initEmptySquares ();
	}

	private void initMyPieces () {
		leftElephant = new Elephant (blackPieceFlag);
		leftElephant.setInitialPosition (7, 0);
		rightElephant = new Elephant (blackPieceFlag);
		rightElephant.setInitialPosition (7, 7);
		leftHorse = new Horse (blackPieceFlag);
		leftHorse.setInitialPosition (7, 1);
		rightHorse = new Horse (blackPieceFlag);
		rightHorse.setInitialPosition (7, 6);
		leftMinister = new Minister (blackPieceFlag);
		leftMinister.setInitialPosition (7, 2);
		rightMinister = new Minister (blackPieceFlag);
		rightMinister.setInitialPosition (7, 5);
		queen = new Queen (blackPieceFlag);
		king = new King (blackPieceFlag);

		// check places of king and queen carefully
		king.setInitialPosition (7, 3);
		queen.setInitialPosition (7, 4);
		

		soldier1 = new Soldier (blackPieceFlag);
		soldier1.setInitialPosition (6, 0);
		soldier2 = new Soldier (blackPieceFlag);
		soldier2.setInitialPosition (6, 1);
		soldier3 = new Soldier (blackPieceFlag);
		soldier3.setInitialPosition (6, 2);
		soldier4 = new Soldier (blackPieceFlag);
		soldier4.setInitialPosition (6, 3);
		soldier5 = new Soldier (blackPieceFlag);
		soldier5.setInitialPosition (6, 4);
		soldier6 = new Soldier (blackPieceFlag);
		soldier6.setInitialPosition (6, 5);
		soldier7 = new Soldier (blackPieceFlag);
		soldier7.setInitialPosition (6, 6);
		soldier8 = new Soldier (blackPieceFlag);
		soldier8.setInitialPosition (6, 7);		
	}

	private void initOpponentPieces () {
		opponentLeftElephant = new Elephant (!blackPieceFlag);
		opponentLeftElephant. setInitialPosition (7, 0);
		opponentRightElephant = new Elephant (!blackPieceFlag);
		opponentRightElephant. setInitialPosition (7, 7);
		opponentLeftHorse = new Horse (!blackPieceFlag);
		opponentLeftHorse. setInitialPosition (7, 1);
		opponentRightHorse = new Horse (!blackPieceFlag);
		opponentRightHorse. setInitialPosition (7, 6);
		opponentLeftMinister = new Minister (!blackPieceFlag);
		opponentLeftMinister. setInitialPosition (7, 2);
		opponentRightMinister = new Minister (!blackPieceFlag);
		opponentRightMinister. setInitialPosition (7, 5);
		opponentQueen = new Queen (!blackPieceFlag);
		opponentKing = new King (!blackPieceFlag);

		// check places of king and queen carefully

			opponentKing.setInitialPosition (7, 3);
			opponentQueen.setInitialPosition (7, 4);

		opponentSoldier1 = new Soldier (!blackPieceFlag);
		opponentSoldier1. setInitialPosition (6, 0);
		opponentSoldier2 = new Soldier (!blackPieceFlag);
		opponentSoldier2.setInitialPosition (6, 1);
		opponentSoldier3 = new Soldier (!blackPieceFlag);
		opponentSoldier3.setInitialPosition (6, 2);
		opponentSoldier4 = new Soldier (!blackPieceFlag);
		opponentSoldier4.setInitialPosition (6, 3);
		opponentSoldier5 = new Soldier (!blackPieceFlag);
		opponentSoldier5.setInitialPosition (6, 4);
		opponentSoldier6 = new Soldier (!blackPieceFlag);
		opponentSoldier6.setInitialPosition (6, 5);
		opponentSoldier7 = new Soldier (!blackPieceFlag);
		opponentSoldier7.setInitialPosition (6, 6);
		opponentSoldier8 = new Soldier (!blackPieceFlag);
		opponentSoldier8.setInitialPosition (6, 7);
	}

	private void arrangeMyPieces () {
		Square s1 = new Square (7, 0, leftElephant);
		Square s2 = new Square (7, 7, rightElephant);
		Square s3 = new Square (7, 1, leftHorse);
		Square s4 = new Square (7, 6, rightHorse);
		Square s5 = new Square (7, 2, leftMinister);
		Square s6 = new Square (7, 5, rightMinister);
		Square s7, s8;

			s7 = new Square (7, 3, king);
			s8 = new Square (7, 4, queen);

		Square s9 = new Square (6, 0, soldier1);
		Square s10 = new Square (6, 1, soldier2);
		Square s11 = new Square (6, 2, soldier3);
		Square s12 = new Square (6, 3, soldier4);
		Square s13 = new Square (6, 4, soldier5);
		Square s14 = new Square (6, 5, soldier6);
		Square s15 = new Square (6, 6, soldier7);
		Square s16 = new Square (6, 7, soldier8);
		
		squares[7][0] = s1;
		squares[7][7] = s2;
		squares[7][1] = s3;
		squares[7][6] = s4;
		squares[7][2] = s5;
		squares[7][5] = s6;
		
		
			squares[7][3] = s7;
			squares[7][4] = s8;
		
		squares[6][0] = s9;
		squares[6][1] = s10;
		squares[6][2] = s11;
		squares[6][3] = s12;
		squares[6][4] = s13;
		squares[6][5] = s14;
		squares[6][6] = s15;
		squares[6][7] = s16;
	}

	private void arrangeOpponentPieces () {
		Square s1 = new Square (0, 0, opponentLeftElephant);
		Square s2 = new Square (0, 7, opponentRightElephant);
		Square s3 = new Square (0, 1, opponentLeftHorse);
		Square s4 = new Square (0, 6, opponentRightHorse);
		Square s5 = new Square (0, 2, opponentLeftMinister);
		Square s6 = new Square (0, 5, opponentRightMinister);
		Square s7, s8;
	

			s7 = new Square (0, 3, opponentKing);
			s8 = new Square (0, 4, opponentQueen);

		Square s9 = new Square (1, 0, opponentSoldier1);
		Square s10 = new Square (1, 1, opponentSoldier2);
		Square s11 = new Square (1, 2, opponentSoldier3);
		Square s12 = new Square (1, 3, opponentSoldier4);
		Square s13 = new Square (1, 4, opponentSoldier5);
		Square s14 = new Square (1, 5, opponentSoldier6);
		Square s15 = new Square (1, 6, opponentSoldier7);
		Square s16 = new Square (1, 7, opponentSoldier8);
		
		squares[0][0] = s1;
		squares[0][7] = s2;
		squares[0][1] = s3;
		squares[0][6] = s4;
		squares[0][2] = s5;
		squares[0][5] = s6;
		
			squares[0][3] = s7;
			squares[0][4] = s8;
		

		squares[1][0] = s9;
		squares[1][1] = s10;
		squares[1][2] = s11;
		squares[1][3] = s12;
		squares[1][4] = s13;
		squares[1][5] = s14;
		squares[1][6] = s15;
		squares[1][7] = s16;
	}

	public void initEmptySquares () {
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new Square(i, j, null);
			}
		}
	}

	public boolean validateMovement (Square targetSquare) {
		boolean flag = false;

		if (targetSquare.isEmptySquare ()) {
			flag = true;
		}
		return flag;
	}

	public void performMovement (Square selectedSquare, Square targetSquare) {
		targetSquare.place (selectedSquare);
		Piece piece = targetSquare.whichPiece ();
		squares[targetSquare.getX ()][targetSquare.getY ()] = new Square (selectedSquare.getX (), selectedSquare.getY (), piece);
		squares[selectedSquare.getX ()][selectedSquare.getY ()] = new Square (selectedSquare.getX (), selectedSquare.getY (), null);
	}
}