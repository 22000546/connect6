package connect6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Stone extends JPanel {
	
	private Point point;
	private Color color;

	public Stone(Point point, int mode) {
		
		setBounds(0, 0, 600, 600);
		setOpaque(false);
		setLayout(null);
		
		this.point = point;
		if(mode == 1) {
			color = Color.BLACK;
		} else if(mode == 2) {
			color = Color.WHITE;
		} else {
			color = Color.RED;
		}
		
	}
	
	public void paintComponent(Graphics g) {
				
		g.setColor(color);
		g.fillOval(point.x-10, point.y-10, 20, 20);
		
	}
	
}
