package connect6;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import connect6.logic.Detecter;

public class ComputerTurn {
	
	private static int[][] points;
	private Detecter detecter;
	private static ArrayList<int[][]> secondStones;

	public ComputerTurn(Detecter detecter, int count) {
		
		this.detecter = detecter;
		
		//secondStones.add()
		
		setPoints(count);
		
	}
		
	public void setPoints(int count) {
		
		if(count == 1) {
			
		}
			
		points = new int[2][2];
		
		points = detecter.detectFiveStones();
		
	}
	
	public int[][] getPoints() {
		return points;
	}
	
}
