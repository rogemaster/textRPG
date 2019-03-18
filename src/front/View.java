package front;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import handler.BtnEvent;
import handler.KeyEvent;
import main.GameStart;

public class View extends JFrame{
	
	public GameStart gs;

	public JPanel mainPane = new JPanel();
	public JLabel distanceDisplay = new JLabel();
	public JLabel mapDisplay = new JLabel();
	public JTextField inputDisplay = new JTextField();
	public JTextArea heroDisplay = new JTextArea();
	public JTextArea explainDisplay = new JTextArea();
	public JTextArea battlehistoryDisplay = new JTextArea();
	public JTextArea monster1 = new JTextArea();
	public JTextArea monster2 = new JTextArea();
	public JTextArea monsterKing = new JTextArea();
	public JButton rePlay = new JButton();
	public JButton next = new JButton();
	public JScrollPane scrollPane = new JScrollPane(battlehistoryDisplay);
	public int MODE = 0;
	public Ment ment = new Ment();
	
	
	public View(GameStart gameStart) {
		this.gs = gameStart;
		init();
		
	}
	
	
	public void init() {
		setSize(800, 600);
		setTitle("textRPG");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		
		heroDisplay.setBorder(new TitledBorder("hero state"));
		heroDisplay.setSize(220, 150);
		heroDisplay.setLocation(7, 125);
		
		explainDisplay.setBorder(new TitledBorder("game explain"));
		explainDisplay.setSize(220, 200);
		explainDisplay.setLocation(7, 270);
		explainDisplay.setText(ment.MENT1);
		
		distanceDisplay.setBorder(new TitledBorder("distance"));
		distanceDisplay.setSize(220, 120);
		distanceDisplay.setLocation(7, 10);
		
		monster1.setBorder(new TitledBorder("monster1"));
		monster1.setSize(120, 160);
		monster1.setLocation(430, 10);
		
		monster2.setBorder(new TitledBorder("monster2"));
		monster2.setSize(120, 160);
		monster2.setLocation(550, 10);
		
		monsterKing.setBorder(new TitledBorder("monsterking"));
		monsterKing.setSize(120, 160);
		monsterKing.setLocation(670, 10);
		
		mapDisplay.setBorder(new TitledBorder("MAP"));
		mapDisplay.setSize(350, 300);
		mapDisplay.setLocation(430, 170);
		
		
		battlehistoryDisplay.setBorder(new TitledBorder("battlehistory"));
		battlehistoryDisplay.setSize(200, 400);
		battlehistoryDisplay.setLocation(230, 10);
		battlehistoryDisplay.setEditable(false);
		//battlehistoryDisplay.setBackground(Color.gray);
		
		//scrollPane.setBorder(new TitledBorder("battlehistory"));
		scrollPane.setSize(200, 460);
		scrollPane.setLocation(230, 10);
		
		inputDisplay.setBorder(new TitledBorder("input"));
		inputDisplay.setSize(700, 80);
		inputDisplay.setLocation(7, 475);
		inputDisplay.addKeyListener(new KeyEvent(this));
		inputDisplay.requestFocus();
		
		
		rePlay.setText("RE");
		rePlay.setSize(59, 35);
		rePlay.setLocation(713, 475);
		rePlay.setEnabled(false);
		rePlay.addActionListener(new BtnEvent(this));
			
		next.setText("NE");
		next.setSize(59, 35);
		next.setLocation(713, 520);
		next.setEnabled(false);
		next.addActionListener(new BtnEvent(this));
		
		mainPane.setBorder(new TitledBorder("mainP"));
		mainPane.setLayout(null);
		mainPane.setLocation(0, 0);
		
		
		mainPane.add(next);
		mainPane.add(rePlay);
		mainPane.add(distanceDisplay);
		mainPane.add(monster1);
		mainPane.add(monster2);
		mainPane.add(monsterKing);
		mainPane.add(heroDisplay);
		mainPane.add(explainDisplay);
		mainPane.add(scrollPane);
		mainPane.add(inputDisplay);
		mainPane.add(mapDisplay);
		
		getContentPane().add(mainPane, null);
		
	}
	
}
