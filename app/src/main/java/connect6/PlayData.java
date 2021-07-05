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
	
	public boolean insertStone(int a, int b, int mode) {
		
		if(stones[b][a] == -1) {
			JOptionPane.showMessageDialog(null, "금지된 위치입니다.");
			return false;
		} else if(stones[b][a] != 0) {
			JOptionPane.showMessageDialog(null, "위치를 중복해서 선택할 수 없습니다.");
			return false;
		} else {
			stones[b][a] = mode;
			return true;
		}
		
	}
	
	public int getStone(int a, int b) {
		return stones[b][a];
	}
	
}
