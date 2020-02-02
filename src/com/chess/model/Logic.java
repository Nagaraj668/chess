package com.chess.model;

import java.awt.*;
public class Logic {

	public static void main (String[] args) {
		int i=0;
		while (i<64) {
			System.out.println ((i/8) + ":" + (i%8));
			i++;
		}
	}
}