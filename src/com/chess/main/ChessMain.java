package com.chess.main;

import javax.swing.*;

import com.chess.model.King;
import com.chess.model.Piece;
import com.chess.ui.BoardUI;


public class ChessMain {

	public static void main (String[] args) {
		
		Piece actualPosition = new King (2, 2);
		Piece targetPosition = new King (3, 4);

		System.out.println (actualPosition.getClassName ());
		
		boolean flag = actualPosition.canMoveToThisPosition (targetPosition);
		if (flag) {
			System.out.println ("Valid Move");
		} else {
			System.out.println ("Not a Valid Move");
		}
		System.out.println ("Actual Position:");
		actualPosition.displayMove ();
		System.out.println ("Target Position:");
		targetPosition.displayMove ();

		SwingUtilities.invokeLater (new Runnable () {
			public void run () {        
				BoardUI boardUI = new BoardUI ();
				boardUI.setVisible (true);
			}
		});
		
	}
}