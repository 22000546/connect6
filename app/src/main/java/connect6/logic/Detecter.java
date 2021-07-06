package connect6.logic;

import java.awt.Point;
import javax.swing.JOptionPane;

import connect6.Board;
import connect6.Counter;

public class Detecter {
	
	private Counter counter;
	private Point p1;
	private Point p2;
	
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
		
		int[][] points = FiveStonesDetecter.detectBothOpened(counter, p1);
		int[][] points2 = FiveStonesDetecter.detectBothOpened(counter, p2);
		
		
		
		return points;
	}

}
