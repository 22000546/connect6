package connect6.logic;

import java.awt.Point;
import java.util.Random;

import javax.swing.JOptionPane;

import connect6.Board;
import connect6.Counter;

public class Detecter {
	
	private Counter counter;
	private Point p1;
	private Point p2;
	private int[][] points;
	
	public Detecter(Counter counter) {
		this.counter = counter;
	}
	
	public void setPoint() {
		p1 = Board.getLastPoint(0);
		p2 = Board.getLastPoint(1);
	}
	
	
	
	public boolean detectWinner(Point p) {
		if(counter.detectLeft(p.x/30-1, p.y/30-1) + counter.detectRight(p.x/30-1, p.y/30-1) >= 5) {
			JOptionPane.showMessageDialog(null, "게임 종료 1");
			return true;
		} else if(counter.detectLeftTop(p.x/30-1, p.y/30-1) + counter.detectRightBottom(p.x/30-1, p.y/30-1) >= 5) {
			JOptionPane.showMessageDialog(null, "게임 종료 2");
			return true;
		} else if(counter.detectCenterTop(p.x/30-1, p.y/30-1) + counter.detectCenterBottom(p.x/30-1, p.y/30-1) >= 5) {
			JOptionPane.showMessageDialog(null, "게임 종료 3");
			return true;
		} else if(counter.detectRightTop(p.x/30-1, p.y/30-1) + counter.detectLeftBottom(p.x/30-1, p.y/30-1) >= 5) {
			JOptionPane.showMessageDialog(null, "게임 종료 4");
			return true;
		}
		return false;
	}
	
	public int[][] detectFiveStones() {
				
		Random random = new Random();
		points = new int[2][2];
		
		FiveStonesDetecter first = new FiveStonesDetecter(counter, p1);
		FiveStonesDetecter second = new FiveStonesDetecter(counter, p2);
		
		int firstStone = first.detectL5();
		int secondStone = second.detectL5();
		
		if(firstStone == 2) {
			points = first.getPoint();
		} else if(secondStone == 2) {
			points = second.getPoint();
		} else if(Math.abs(firstStone) + Math.abs(secondStone) == 2 || Math.abs(firstStone) + Math.abs(secondStone) == 1) {
			if(firstStone == -1) {
				points[0][0] = first.getPointIndex(0, 0);
				points[0][1] = first.getPointIndex(0, 1);
			} else if(firstStone == 1) {
				points[0][0] = first.getPointIndex(1, 0);
				points[0][1] = first.getPointIndex(1, 1);
			} else {
				points[0][0] = random.nextInt(19);
				points[0][1] = random.nextInt(19);
			}
			
			if(secondStone == -1) {
				points[1][0] = second.getPointIndex(0, 0);
				points[1][1] = second.getPointIndex(0, 1);
			} else if(secondStone == 1) {
				points[1][0] = second.getPointIndex(1, 0);
				points[1][1] = second.getPointIndex(1, 1);
			} else {
				points[1][0] = random.nextInt(19);
				points[1][1] = random.nextInt(19);
			}
			
		} else {
			
			points[0][0] = random.nextInt(19);
			points[0][1] = random.nextInt(19);
			points[1][0] = random.nextInt(19);
			points[1][1] = random.nextInt(19);
		}
		
		return points;
	}

}
