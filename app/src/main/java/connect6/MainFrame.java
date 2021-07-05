package connect6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JFrame frame;
	static final int WIDTH = 1200;
	static final int HEIGHT = 700;
	
	public MainFrame() {
		
		frame = new JFrame();
		frame.setBounds(100, 50, WIDTH, HEIGHT);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Board board = new Board();
		board.addMouseListener(board);
		board.addMouseMotionListener(board);
		frame.add(board);
		
		JLabel time = new JLabel("시간");
		time.setBackground(Color.WHITE);
		time.setBounds(850, 50, 200, 100);
		frame.add(time);
		
		JButton forbidden = new JButton("착수 금지점 설정");
		forbidden.setBounds(850, 300, 200, 100);
		forbidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		frame.add(forbidden);
		
		
		frame.setVisible(true);
		
	}
	
}
