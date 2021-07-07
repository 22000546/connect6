package connect6;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import connect6.logic.Detecter;

public class ComputerTurn {
	
	private static int[][] points;
	private Detecter detecter;
	private static HashMap<Integer, Integer> secondStones;

	public ComputerTurn(Detecter detecter, int count) {
		
		this.detecter = detecter;
		/*
		
		for(int i = 0 ; i < 8; i ++) {
			secondStones.put(i, i+1);
		}
		secondStones.put(8, 1);
		
		Random random = new Random();
		int index = random.nextInt(8);
		int first = secondStones.get(index);
		if(first == 1) {
			//points[0][0] = Point(8, 8);
			
		}*/
		
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
