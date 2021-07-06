package connect6.logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import connect6.Board;
import connect6.Counter;

public class FiveStonesDetecter {

	private int[][] points;
	
	
	public FiveStonesDetecter() {
		points = new int[2][2];
	}
	
	
	// CASE 1 : 0111110 / 0222220
	public static int[][] detectBothOpened(Counter counter, Point p) {
				
		int[][] points = new int[2][2];
		
		//int userMode = counter.getData().getStone(p.x/30-1, p.y/30-1);
		
		if(counter.detectLeft(p.x/30-1, p.y/30-1) + counter.detectRight(p.x/30-1, p.y/30-1) >= 4) {
			int cnt1 = counter.detectLeft(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectRight(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1-cnt1-1;
			points[0][1] = p.y/30-1;
			points[1][0] = p.x/30-1+cnt2+1;
			points[1][1] = p.y/30-1;
			return points;
		} else if(counter.detectLeftTop(p.x/30-1, p.y/30-1) + counter.detectRightBottom(p.x/30-1, p.y/30-1) >= 4) {
			int cnt1 = counter.detectLeftTop(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectRightBottom(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1-cnt1-1;
			points[0][1] = p.y/30-1-cnt1-1;
			points[1][0] = p.x/30-1+cnt2+1;
			points[1][1] = p.y/30-1+cnt2+1;
			return points;
		} else if(counter.detectCenterTop(p.x/30-1, p.y/30-1) + counter.detectCenterBottom(p.x/30-1, p.y/30-1) >= 4) {
			int cnt1 = counter.detectCenterTop(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectCenterBottom(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1;
			points[0][1] = p.y/30-1-cnt1-1;
			points[1][0] = p.x/30-1;
			points[1][1] = p.y/30-1+cnt2+1;
			return points;
		} else if(counter.detectRightTop(p.x/30-1, p.y/30-1) + counter.detectLeftBottom(p.x/30-1, p.y/30-1) >= 4) {
			int cnt1 = counter.detectRightTop(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectLeftBottom(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1+cnt1+1;
			points[0][1] = p.y/30-1-cnt1-1;
			points[1][0] = p.x/30-1-cnt2-1;
			points[1][1] = p.y/30-1+cnt2+1;
			return points;
		}
		
		Random random = new Random();
		
		points[0][0] = random.nextInt(19);
		points[0][1] = random.nextInt(19);
		points[1][0] = random.nextInt(19);
		points[1][1] = random.nextInt(19);
		
		
		return points;
		
	}
	
	public int[][] getPoint() {
		return points;
	}
	
	
	// CASE 2 : 

}
