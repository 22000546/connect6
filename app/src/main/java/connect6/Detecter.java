package connect6;

public class Detecter {
	
	private PlayData data;
	
	public Detecter(PlayData data) {
		this.data = data;
	}
	
	public int detectLeftTop(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		while(x >= 0 && y >= 0 && data.getStone(x-1, y-1) == mode) {
			count ++;
			x --;
			y --;
		}
		return count;
	}
	
	public int detectCenterTop(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		while(x >= 0 && y >= 0 && data.getStone(x, y-1) == mode) {
			count ++;
			y --;
		}
		return count;
	}
	
	public int detectRightTop(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		while(x >= 0 && y >= 0 && data.getStone(x+1, y+1) == mode) {
			count ++;
			x ++;
			y ++;
		}
		return count;
	}
	
	public int detectLeft(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		while(x > 0 && y > 0 && data.getStone(x-1, y) == mode) {
			count ++;
			x --;
		}
		
		return count;
		
		
	}
	
	public int detectRight(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		while(x > 0 && y > 0 && data.getStone(x+1, y) == mode) {
			count ++;
			x ++;
		}
		return count;
	}
	
}
