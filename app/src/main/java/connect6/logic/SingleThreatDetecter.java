package connect6.logic;

import java.awt.Point;

import connect6.Counter;

public class SingleThreatDetecter {
	
	private int[][] points;
	private Counter counter;
	private Point p;
	
	public SingleThreatDetecter(Counter counter, Point p) {
		points = new int[2][2];
		this.counter = counter;
		this.p = p;
	}

	public int isBlocked(int n) {
		if(counter.detectLeft(p.x/30-1, p.y/30-1) + counter.detectRight(p.x/30-1, p.y/30-1) == n-1) {
			int cnt1 = counter.detectLeft(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectRight(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1-cnt1-1;
			points[0][1] = p.y/30-1;
			points[1][0] = p.x/30-1+cnt2+1;
			points[1][1] = p.y/30-1;
			if(!counter.getData().isEmpty(points[0][0], points[0][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[1][0], points[1][0])) {
						return 1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[1][0], points[1][0]) && counter.getData().isEmpty(points[1][0]+1, points[1][0])) {
						return 1;
					}
				}
			} else if(!counter.getData().isEmpty(points[1][0], points[1][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[0][0], points[0][1])) {
						return -1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[0][0], points[0][1]) && counter.getData().isEmpty(points[0][0]-1, points[0][1])) {
						return -1;
					}
				}
				
			}
		} else if(counter.detectLeftTop(p.x/30-1, p.y/30-1) + counter.detectRightBottom(p.x/30-1, p.y/30-1) == n-1) {
			int cnt1 = counter.detectLeftTop(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectRightBottom(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1-cnt1-1;
			points[0][1] = p.y/30-1-cnt1-1;
			points[1][0] = p.x/30-1+cnt2+1;
			points[1][1] = p.y/30-1+cnt2+1;
			if(!counter.getData().isEmpty(points[0][0], points[0][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[1][0], points[1][0])) {
						return 1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[1][0], points[1][0]) && counter.getData().isEmpty(points[1][0]+1, points[1][0]+1)) {
						return 1;
					}
				}
			} else if(!counter.getData().isEmpty(points[1][0], points[1][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[0][0], points[0][1])) {
						return -1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[0][0], points[0][1]) && counter.getData().isEmpty(points[0][0]-1, points[0][1]-1)) {
						return -1;
					}
				}
				
			}
		} else if(counter.detectCenterTop(p.x/30-1, p.y/30-1) + counter.detectCenterBottom(p.x/30-1, p.y/30-1) == n-1) {
			int cnt1 = counter.detectCenterTop(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectCenterBottom(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1;
			points[0][1] = p.y/30-1-cnt1-1;
			points[1][0] = p.x/30-1;
			points[1][1] = p.y/30-1+cnt2+1;
			if(!counter.getData().isEmpty(points[0][0], points[0][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[1][0], points[1][0])) {
						return 1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[1][0], points[1][0]) && counter.getData().isEmpty(points[1][0], points[1][0]+1)) {
						return 1;
					}
				}
			} else if(!counter.getData().isEmpty(points[1][0], points[1][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[0][0], points[0][1])) {
						return -1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[0][0], points[0][1]) && counter.getData().isEmpty(points[0][0], points[0][1]-1)) {
						return -1;
					}
				}
				
			}
			
		} else if(counter.detectRightTop(p.x/30-1, p.y/30-1) + counter.detectLeftBottom(p.x/30-1, p.y/30-1) == n-1) {
			int cnt1 = counter.detectRightTop(p.x/30-1, p.y/30-1);
			int cnt2 = counter.detectLeftBottom(p.x/30-1, p.y/30-1);
			points[0][0] = p.x/30-1+cnt1+1;
			points[0][1] = p.y/30-1-cnt1-1;
			points[1][0] = p.x/30-1-cnt2-1;
			points[1][1] = p.y/30-1+cnt2+1;
			if(!counter.getData().isEmpty(points[0][0], points[0][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[1][0], points[1][0])) {
						return 1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[1][0], points[1][0]) && counter.getData().isEmpty(points[1][0]-1, points[1][0]+1)) {
						return 1;
					}
				}
			} else if(!counter.getData().isEmpty(points[1][0], points[1][1])) {
				if(n == 5) {
					if(counter.getData().isEmpty(points[0][0], points[0][1])) {
						return -1;
					}
				} else if(n == 4) {
					if(counter.getData().isEmpty(points[0][0], points[0][1]) && counter.getData().isEmpty(points[0][0]+1, points[0][1]-1)) {
						return -1;
					}
				}
				
			}
		}
		
		return 0;

	}
	
	public int[][] getPoint() {
		return points;
	}
	
	public int[] getPointIndex(int a) {
		return points[a];
	}
	
}
