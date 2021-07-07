package connect6;

import javax.swing.JPanel;
import java.util.Random;

public class Forbidden extends JPanel {
	
	private static int numOfPoints;
	private static int[][] points;
	
	public Forbidden() {
		
		Random random = new Random();
		
		numOfPoints = random.nextInt(6);
		
		points = new int[numOfPoints][2];
		
		for(int i = 0; i < numOfPoints; i ++) {
		
			points[i][0] = random.nextInt(19);
			points[i][1] = random.nextInt(19);
			while(points[i][0] == 9 && points[i][1] == 9) {
				points[i][0] = random.nextInt(19);
				points[i][1] = random.nextInt(19);
			}
			
		}
		
	}
	
	public int[][] getPoints() {
		return points;
	}
	

}
