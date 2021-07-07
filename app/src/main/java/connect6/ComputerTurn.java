package connect6;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import connect6.logic.Detecter;

public class ComputerTurn {
	
	private static int[][] points;
	private Detecter detecter;

	public ComputerTurn(Detecter detecter, int count) {
		
		this.detecter = detecter;
		
		setPoints(count);
		
	}
		
	public void setPoints(int count) {
		
		if(count == 1) {
			
		}
			
		points = new int[2][2];
		
		points = detecter.detectAll();
		
		System.out.print(points[0][0] + " ");
		System.out.println(points[0][1]);
		System.out.print(points[1][0] + " ");
		System.out.println(points[1][1]);
		System.out.println();
		
	}
	
	public int[][] getPoints() {
		return points;
	}
	
}
