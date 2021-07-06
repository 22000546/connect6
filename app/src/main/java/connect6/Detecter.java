package connect6;

public class Detecter {
	
	private PlayData data;
	
	public Detecter(PlayData data) {
		this.data = data;
	}
	
	public int detectLeftTop(int x, int y) {
		int count = 0;
		int turn = data.getStone(x, y);
		
		try {
			while(data.getStone(x-1, y-1) == turn) {
				count ++;
				x --;
				y --;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
	public int detectCenterTop(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		try {
			while(data.getStone(x, y-1) == mode) {
				count ++;
				y --;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
	public int detectRightTop(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		try {
			while(data.getStone(x+1, y+1) == mode) {
				count ++;
				x ++;
				y ++;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
	public int detectLeft(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		try {
			while(data.getStone(x-1, y) == mode) {
				count ++;
				x --;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
	public int detectRight(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		try {
			while(data.getStone(x+1, y) == mode) {
				count ++;
				x ++;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
	public int detectLeftBottom(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		try {
			while(data.getStone(x-1, y+1) == mode) {
				count ++;
				x --;
				y ++;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
	public int detectCenterBottom(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		try {
			while(data.getStone(x, y+1) == mode) {
				count ++;
				y ++;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
	public int detectRightBottom(int x, int y) {
		int count = 0;
		int mode = data.getStone(x, y);
		
		try {
			while(data.getStone(x+1, y+1) == mode) {
				count ++;
				x ++;
				y ++;
			}
		} catch (Exception e) {
			
		}
		
		return count;
	}
	
}
