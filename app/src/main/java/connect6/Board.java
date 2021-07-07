package connect6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import connect6.logic.Detecter;

public class Board extends JPanel implements MouseListener, MouseMotionListener {
	
	static final int BOARD = 540;
	
	private static int turn; // black : 1 / white : 2 / forbidden : 3
	private static int turnCount;
	private static int count = 0;
	private static int forbiddenCount = 0;
	
	/*
	 * For turn
	 */
	private static int computerTurn;
	private static int userTurn;
	
	/*
	 * For mode setting
	 */
	private static int mode = 0;
	private static final int READY = -1;
	private static final int PLAY = 1;
	private static final int END = 3;
	
	private int userNum;
	
	/*
	 * 
	 */
	private static ArrayList<Point> userLastPoint;
	
	PlayData data;
	Counter counter;
	Detecter detecter;
	
	public Board() {
		
		mode = READY;
		
		setBounds(25, 50, 600, 600);
		setLayout(null);
	
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		data = new PlayData();
		counter = new Counter(data);
		detecter = new Detecter(counter);
		userLastPoint = new ArrayList<>();
				
	}
	
	public void setForbidden(int forbiddenMode) {
		if(forbiddenMode == 1) {
			Forbidden forbidden = new Forbidden();
			int[][] points = forbidden.getPoints();
			
			if(points != null) {
				for(int i = 0; i < points.length; i ++) {
					Point p = new Point();
					
					p.x = (points[i][0] + 1) * 30;
					p.y = (points[i][1] + 1) * 30;

					Stone s = new Stone(p, 3);
					s = new Stone(p, 3);
					this.add(s);
					s.repaint();
					data.insertStone(points[i][0], points[i][1], 3);
				}
				mode = PLAY;
				turn = 1;
			}
		} else if(forbiddenMode == 2) {
			String input = JOptionPane.showInputDialog("원하는 갯수를 입력해주세요. (0-5)");
			if(!input.matches("[0-5]")) {
				JOptionPane.showMessageDialog(null, "형식이 올바르지 않습니다. 0부터 5까지의 숫자만 입력해주세요.");
				MainFrame.setForbiddenMode = false;
			} else {
				userNum = Integer.parseInt(input);
				turn = 3;
			}
		}
	}
	
	public void setFirst() {
		computerTurn = MainFrame.getComputerTurn();
		userTurn = MainFrame.getUserTurn();
		Point p = new Point();
		if(userTurn == 1) {
			p.x = p.y = 300;
			Stone stone = new Stone(p, 1);
			add(stone);
			stone.repaint();
			count ++;
			turnCount = 2;
			userLastPoint.add(p);
			userLastPoint.add(p);
			data.insertStone(p.x/30-1, p.y/30-1, 1);
			setComputerStone();
			return;
		} else {
			p.x = p.y = 300;
			Stone stone = new Stone(p, 1);
			add(stone);
			stone.repaint();
			count ++;
			turnCount = 2;
			data.insertStone(p.x/30-1, p.y/30-1, 1);
			return;
		}
	}
	
	public void setComputerStone() {
		
		detecter.setPoint();
		
		ComputerTurn ct = new ComputerTurn(detecter, count);
		int[][] points = ct.getPoints();
		
		
		for(int i = 0; i < 2; i ++) {
			
			Point p = new Point();
			
			p.x = (points[i][0] + 1) * 30;
			p.y = (points[i][1] + 1) * 30;

			Stone s = new Stone(p, computerTurn);
			s = new Stone(p, computerTurn);
			/*
			setColor(Color.GREEN);
			drawOval(p.x-11, p.y-11, 22, 22);
			*/
			this.add(s);
			s.repaint();
			data.insertStone(points[i][0], points[i][1], computerTurn);
			turnCount += 2;
			if(detecter.detectWinner(p)) {
				mode = END;
				return;
			}
			userLastPoint.clear();
		}
		
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
		
		if(mode == READY) {
			if(turn == 3) {
				if(userNum != 0) {
					if(forbiddenCount <= userNum) {
						if(p.x/30-1 < 0 || p.x/30-1 > 18 || p.y/30-1 < 0 || p.y/30-1 > 18) {
							JOptionPane.showMessageDialog(null, "범위를 벗어났습니다.");
						} else {
							Stone s = new Stone(p, 3);
							s = new Stone(p, 3);
							this.add(s);
							s.repaint();
							data.insertStone(p.x/30-1, p.y/30-1, 3);
							forbiddenCount ++;
						}
					}
				}
				if(forbiddenCount == userNum) {
					turn = 1;
					mode = PLAY;
				}
			}
		} else if(mode == PLAY) {
			if(count == 0) {
				
			} else {
				if(p.x/30-1 < 0 || p.x/30-1 > 18 || p.y/30-1 < 0 || p.y/30-1 > 18) {
					JOptionPane.showMessageDialog(null, "범위를 벗어났습니다.");
				} else {
					if(data.isEmpty(p.x/30-1, p.y/30-1)) {
						data.insertStone(p.x/30-1, p.y/30-1, userTurn);
						Stone stone = new Stone(p, userTurn);
						userLastPoint.add(p);
						add(stone);
						stone.repaint();
						count ++;
						turnCount ++;
						// 승패 판정 
						if(detecter.detectWinner(p)) {
							mode = END;
							return;
						}
						if(turnCount % 2 == 0) {
							setComputerStone();
						}
						
					}
				}
			}
		}
		MainFrame.setTurn(Utils.getTurnToString(turn));
		
		
		
		
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
			
		Stone stone = new Stone(p, turn);
		stone.repaint();
		*/
	}
	
	public int getTurnCount() {
		return turnCount;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public static Point getLastPoint(int index) {
		return userLastPoint.get(index);
	}

}
