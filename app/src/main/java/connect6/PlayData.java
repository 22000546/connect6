package connect6;

import javax.swing.JOptionPane;

public class PlayData {

	private int[][] stones;
	/*
	 * <mode>
	 * forbidden : -1
	 * none : 0
	 * black : 1
	 * white : 2
	 */
	
	public PlayData() {
		stones = new int[19][19];
	}
	
	public boolean isEmpty(int a, int b) {
		if(stones[a][b] == 3) {
			//JOptionPane.showMessageDialog(null, "금지된 위치입니다.");
			return false;
		} else if(stones[a][b] != 0) {
			//JOptionPane.showMessageDialog(null, "위치를 중복해서 선택할 수 없습니다.");
			return false;
		} else {
			return true;
		}
	}
		
	public boolean insertStone(int a, int b, int turn) {
		
		stones[a][b] = turn;
		return true;
		
	}
	
	public int getStone(int a, int b) {
		return stones[a][b];
	}
	
}
