package connect6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener, MouseMotionListener {
	
	static final int BOARD = 540;
	private int mode = 1; // black : 1 / white : 2
	private int count = 0;
	PlayData data;
	Detecter detecter;
	
	public Board() {
		
		setBounds(25, 50, 600, 600);
		setLayout(null);
	
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		data = new PlayData();
		detecter = new Detecter(data);
		
		/*
		Forbidden forbidden = new Forbidden();
		int[][] points = forbidden.getPoints();
		Point p = new Point();
		
		if(points != null) {
			for(int i = 0; i < points.length; i ++) {
				
				p.x = (points[i][0] + 1) * 30;
				p.y = (points[i][1] + 1) * 30;

				
				Stone s = new Stone(p, 3);
				this.add(s);
				System.out.println(p.x + " " + p.y);
				data.insertStone(points[i][0], points[i][1], 3);
			}
		}
		*/
		
	}
	
	public void paintComponent(Graphics g) {
				
		setBackground(new Color(204, 153, 102));
		g.drawRect(30, 30, BOARD, BOARD);
		for(int i = 30; i < BOARD+30; i += 30) {
			g.drawLine(i, 30, i, BOARD+30);
			g.drawLine(30, i, BOARD+30, i);
		}
		
		for(int i = 115; i <=475; i += 180) {
			for(int j = 115; j <= 475; j += 180) {
				g.fillOval(i, j, 10, 10);
			}
		}
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Point p = e.getPoint();
		System.out.println(mode);
		
		if(count == 0) {
			p.x = p.y = 300;
			Stone stone = new Stone(p, 1);
			add(stone);
			stone.repaint();
			count ++;
			data.insertStone(p.x/30-1, p.y/30-1, mode);
			mode = 2;
			return;
		}
		
		if(p.x % 30 >= 15) {
			p.x = 30 * (p.x / 30 + 1);
		} else {
			p.x = 30 * (p.x / 30);
		}
		if(p.y % 30 >= 15) {
			p.y = 30 * (p.y / 30 + 1);
		} else {
			p.y = 30 * (p.y / 30);
		}
		
		if(p.x/30-1 < 0 || p.x/30-1 > 18 || p.y/30-1 < 0 || p.y/30-1 > 18) {
			JOptionPane.showMessageDialog(null, "범위를 벗어났습니다.");
		} else {
			if(count % 2 == 1) {
				if(mode == 1) {
					mode = 2;
				} else if(mode == 2) {
					mode = 1;
				}
			}
			if(data.insertStone(p.x/30-1, p.y/30-1, mode)) {
				Stone stone = new Stone(p, mode);
				add(stone);
				stone.repaint();
				count ++;
				// 승패 판정 
				if(detecter.detectLeft(p.x/30-1, p.y/30-1) + detecter.detectRight(p.x/30-1, p.y/30-1) >= 5) {
					JOptionPane.showMessageDialog(null, "게임 종료");
				}
				/*
				for(int i = 0; i < 19; i ++) {
					for(int j = 0; j < 19; j ++) {
						System.out.print(data.getStone(i, j) + " ");
					}
					System.out.println();
				}
				System.out.println();
				*/
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		Point p = e.getPoint();
		
 		if(p.x % 30 >= 15) {
			p.x = 30 * (p.x / 30 + 1);
		} else {
			p.x = 30 * (p.x / 30);
		}
		if(p.y % 30 >= 15) {
			p.y = 30 * (p.y / 30 + 1);
		} else {
			p.y = 30 * (p.y / 30);
		}
			
		Stone stone = new Stone(p, mode);
		stone.paintComponent(getGraphics());
		*/
	}
	
	public void setMode(int n) {
		mode = n;
	}
	
	public int getMode() {
		return mode;
	}

}
