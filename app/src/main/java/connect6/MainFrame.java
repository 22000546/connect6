package connect6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JFrame frame;
	static final int WIDTH = 1300;
	static final int HEIGHT = 700;
	static boolean setForbiddenMode = false;
	
	Board board;
	JLabel title;
	JButton forbidden;
	JButton set;
	
	static JLabel turn;
	static JLabel mode;
	static int userTurn;
	static int computerTurn;
	
	public MainFrame() {
		
		frame = new JFrame();
		frame.setBounds(100, 50, WIDTH, HEIGHT);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		board = new Board();
		board.addMouseListener(board);
		board.addMouseMotionListener(board);
		frame.getContentPane().add(board);
		
		title = new JLabel("CONNECT 6");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(Color.WHITE);
		title.setFont(new Font("PT Serif", Font.BOLD, 45));
		title.setBounds(650, 50, 650, 100);
		frame.getContentPane().add(title);
		
		mode = new JLabel("모드 설정");
		mode.setHorizontalAlignment(SwingConstants.CENTER);
		mode.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		mode.setHorizontalAlignment(SwingConstants.CENTER);
		mode.setBounds(925, 125, 100, 80);
		frame.getContentPane().add(mode);
		
		JLabel comment1 = new JLabel("차례 : " + Utils.getTurnToString(board.getTurn()));
		comment1.setBounds(700, 300, 200, 100);
		frame.getContentPane().add(comment1);
		
		turn = new JLabel();
		turn.setBounds(750, 300, 200, 100);
		frame.getContentPane().add(turn);
		//static JLabel 
		
		
		forbidden = new JButton("랜덤 설정");
		forbidden.setBounds(738, 474, 100, 60);
		forbidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!setForbiddenMode) {
					setForbiddenMode = true;
					forbidden.setForeground(Color.DARK_GRAY);
					board.setForbidden(1);
					mode.setText("게임 시작");
					board.setFirst();
				} else {
					JOptionPane.showMessageDialog(null, "이미 설정하셨습니다.");
				}
			}
		});
		frame.getContentPane().add(forbidden);
		
		set = new JButton("심판 설정");
		set.setBounds(850, 474, 100, 60);
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!setForbiddenMode) {
					setForbiddenMode = true;
					set.setForeground(Color.DARK_GRAY);
					board.setForbidden(2);
					mode.setText("게임 시작");
					board.setFirst();
				} else {
					JOptionPane.showMessageDialog(null, "이미 설정하셨습니다.");
				}
			}
		});
		frame.getContentPane().add(set);
		
		JLabel random = new JLabel("착수 금지점 설정");
		random.setBounds(710, 412, 100, 50);
		frame.getContentPane().add(random);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton black = new JRadioButton("선공");
		black.setBounds(996, 489, 70, 30);
		black.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					userTurn = 1;
					computerTurn = 2;
				} else if(e.getStateChange() == ItemEvent.DESELECTED) {
					userTurn = 2;
					computerTurn = 1;
				}
			}
		});
		group.add(black);
		frame.getContentPane().add(black);
		
		JRadioButton white = new JRadioButton("후공");
		white.setBounds(1096, 489, 70, 30);
		white.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					userTurn = 2;
					computerTurn = 1;
				} else if(e.getStateChange() == ItemEvent.DESELECTED) {
					userTurn = 1;
					computerTurn = 2;
				}
			}
		});
		group.add(white);
		frame.getContentPane().add(white);
		
		JLabel turn = new JLabel("흑백 결정");
		turn.setBounds(975, 412, 100, 50);
		frame.getContentPane().add(turn);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(Color.DARK_GRAY);
		line.setBounds(650+325-230, 400, 500-40, 1);
		frame.getContentPane().add(line);
		
		JLabel line2 = new JLabel();
		line2.setOpaque(true);
		line2.setBackground(Color.DARK_GRAY);
		line2.setBounds(650 + 175, 140, 300, 1);
		frame.getContentPane().add(line2);
		
		//JButton start = new JButton("게임 시작하기");
		//start.setBounds(650)
		
		JLabel background = new JLabel();
		background.setOpaque(true);
		background.setBackground(Color.LIGHT_GRAY);
		background.setBounds(675, 200, 600, 400);
		frame.getContentPane().add(background);
		
		frame.setVisible(true);
		
	}
	
	public static void setTurn(String str) {
		turn.setText(str);
	}
	
	public static int getUserTurn() {
		return userTurn;
	}
	
	public static int getComputerTurn() {
		return computerTurn;
	}
	
}
