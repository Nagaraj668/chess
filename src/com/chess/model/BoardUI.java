package com.chess.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardUI extends JFrame implements ActionListener {

	private static final String TITLE = "Genius Chess - Multiplayer Game";
	private GridLayout gridLayout = new GridLayout(0,8);
	private int row1 = 1, row2 = -1, rowNumber = 0;
	private JPanel boardPanel;
	
	// menu variables
	private JMenuBar menuBar = new JMenuBar ();
	private JMenu fileMenu, helpMenu;
	private JMenuItem connectMenuItem, aboutMenuItem, helpMenuItem;

	// movement squares
	CustomSquareUI selectedSquareUI, targetSquareUI;

	// logic
	private Board board;

	public BoardUI () {
		super (TITLE);

		// default configuration
		setExtendedState (MAXIMIZED_BOTH);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout (new FlowLayout ());

		// init methods execution
		initMenu ();		
		initBoardLogic ();
		initBoardSquaresUI ();
		initSquaresWithPieces ();
	}

	public void initMenu () {
		connectMenuItem = new JMenuItem ("Connect");
		aboutMenuItem = new JMenuItem ("About");
		helpMenuItem = new JMenuItem ("Help");

		fileMenu = new JMenu ("File");
		helpMenu = new JMenu ("Help");

		fileMenu.add (connectMenuItem);
		helpMenu.add (aboutMenuItem);
		helpMenu.add (helpMenuItem);

		menuBar.add (fileMenu);
		menuBar.add (helpMenu);

		setJMenuBar (menuBar);
	}


	private void initBoardSquaresUI () {
		boardPanel = new JPanel();
	        boardPanel.setLayout(gridLayout);
		boardPanel.setPreferredSize(new Dimension(500, 500));
		for (int i=1; i<= 64; i++) {
			boardPanel.add (getAlternateSquare ());
		}
		add (boardPanel);
	}

	public void initBoardLogic () {
		board = new Board ();
		board.setBlackPieceFlag (false);
		board.initBoard ();
	}

	public void initSquaresWithPieces () {
		Square[][] squares = board.getSquares ();
		Component[] components = boardPanel.getComponents ();

		int i=0;
		while (i<64) {
			CustomSquareUI squareUI = (CustomSquareUI) components[i];
			squareUI.setSquare (squares[i / 8][i % 8]);
			boardPanel.remove(components[i]);
			boardPanel.add(squareUI);
			i++;
		}
	}

	public JButton getAlternateSquare () {
		JButton btn = null;
		if (rowNumber % 8 == 0) {
			if (row1 % 2 == 0) {
				btn = new BlackSquareUI ();
			} else {
				btn = new WhiteSquareUI ();
			}
			row1++;
		} else {
			if (row2 % 2 == 0) {
				btn = new WhiteSquareUI ();
			} else {
				btn = new BlackSquareUI ();
			}
			row2++;
		}
		rowNumber++;
		btn.addActionListener (this);
        	return btn;
	}

	public void actionPerformed (ActionEvent e) {
		CustomSquareUI squareUI = (CustomSquareUI) e.getSource ();
		if (selectedSquareUI == null) {
			selectedSquareUI = squareUI;
			selectedSquareUI.highlight ();
		} else {
			targetSquareUI = squareUI;
			selectedSquareUI.validateMove (board, targetSquareUI);
			updateBoardUI ();
			resetPostMovement ();
		}
	}

	public void updateBoardUI () {
		selectedSquareUI.deHighlight ();
		initSquaresWithPieces ();
	}

	public void resetPostMovement () {
		selectedSquareUI = null;
		targetSquareUI = null;
	}
}