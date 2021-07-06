package connect6;

import java.util.Random;

public class ComputerTurn {
	
	private static int[][] points;

	public ComputerTurn() {
		
		Random random = new Random();
		
		points = new int[2][2];
		
		points[0][0] = random.nextInt(19);
		points[0][1] = random.nextInt(19);
		points[1][0] = random.nextInt(19);
		points[1][1] = random.nextInt(19);
		
	}
	
	public int[][] getPoints() {
		return points;
	}
	
}
