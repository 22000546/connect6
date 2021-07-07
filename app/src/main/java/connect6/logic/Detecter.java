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
	private int index = 0;
	private int count = 0;
	
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
	
	public int[][] detectAll() {
		
		DoubleThreatDetecter double1 = new DoubleThreatDetecter(counter, p1);
		DoubleThreatDetecter double2 = new DoubleThreatDetecter(counter, p2);
		
		SingleThreatDetecter single1 = new SingleThreatDetecter(counter, p1);
		SingleThreatDetecter single2 = new SingleThreatDetecter(counter, p2);
		
		Random random = new Random();
		
		points = new int[3][2];
		
		while(count < 2) {
			
			count += double1.isBothOpened(5);
			if(count >= 2) {
				points = double1.getPoint();
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += double2.isBothOpened(5);
			if(count >= 2) {
				points = double2.getPoint();
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += double1.isBothOpened(4);
			if(count >= 2) {
				points = double1.getPoint();
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += double2.isBothOpened(4);
			if(count >= 2) {
				points = double2.getPoint();
				count = 0;
				index = 0;
				break;
			}
			
			count += Math.abs(single1.isBlocked(5));
			if(count >= 1) {
				if(single1.isBlocked(5) == 1) {
					points[index] = single1.getPointIndex(1);
					index ++;
				} else if(single1.isBlocked(5) == -1) {
					points[index] = single1.getPointIndex(0);
					index ++;
				}
				if(points[0][0] == points[1][0] && points[0][1] == points[1][1]) {
					count --;
				}
			}
			if(count >= 2) {
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += Math.abs(single2.isBlocked(5));
			if(count >= 1) {
				if(single2.isBlocked(5) == 1) {
					points[index] = single2.getPointIndex(1);
					index ++;
				} else if(single2.isBlocked(5) == -1) {
					points[index] = single2.getPointIndex(0);
					index ++;
				}
				if(points[0][0] == points[1][0] && points[0][1] == points[1][1]) {
					count --;
				}
			}
			if(count >= 2) {
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += Math.abs(single1.isBlocked(4));
			if(count >= 1) {
				if(single1.isBlocked(4) == 1) {
					points[index] = single1.getPointIndex(1);
					index ++;
				} else if(single1.isBlocked(4) == -1) {
					points[index] = single1.getPointIndex(0);
					index ++;
				}
				if(points[0][0] == points[1][0] && points[0][1] == points[1][1]) {
					count --;
				}
			}
			if(count >= 2) {
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += Math.abs(single2.isBlocked(4));
			if(count >= 1) {
				if(single2.isBlocked(4) == 1) {
					points[index] = single2.getPointIndex(1);
					index ++;
				} else if(single2.isBlocked(4) == -1) {
					points[index] = single2.getPointIndex(0);
					index ++;
				}
				if(points[0][0] == points[1][0] && points[0][1] == points[1][1]) {
					count --;
				}
			}
			if(count >= 2) {
				count = 0;
				index = 0;
				break;
			}
			
			count += double1.isBothOpened(3);
			if(count >= 2) {
				points = double1.getPoint();
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += double2.isBothOpened(3);
			if(count >= 2) {
				points = double2.getPoint();
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += double1.isBothOpened(2);
			if(count >= 2) {
				points = double1.getPoint();
				count = 0;
				index = 0;
				break;
			}
			System.out.println(count);
			
			count += double2.isBothOpened(2);
			if(count >= 2) {
				points = double2.getPoint();
				count = 0;
				index = 0;
				break;
			}
			
			if(count == 0) {
				points[0][0] = random.nextInt(10) + 5;
				points[0][1] = random.nextInt(10) + 5;
				points[1][0] = random.nextInt(10) + 5;
				points[1][1] = random.nextInt(10) + 5;
				while(!(counter.getData().isEmpty(points[0][0], points[0][1]) && counter.getData().isEmpty(points[1][0], points[1][1]))) {
					points[0][0] = random.nextInt(10) + 5;
					points[0][1] = random.nextInt(10) + 5;
					points[1][0] = random.nextInt(10) + 5;
					points[1][1] = random.nextInt(10) + 5;
				}
				break;
			} else if(count == 1) {
				points[1][0] = random.nextInt(10) + 5;
				points[1][1] = random.nextInt(10) + 5;
				while(!counter.getData().isEmpty(points[1][0], points[1][1])) {
					points[1][0] = random.nextInt(10) + 5;
					points[1][1] = random.nextInt(10) + 5;
				}
			}
		
			index = 0;
			
		}
		
		return points;
		
	}
	
	
	

}
