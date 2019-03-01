package textRPGt2.window;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import textRPGt2.charc.Hero;
import textRPGt2.charc.Monster;


public class Windows extends JFrame implements KeyListener{

	JPanel mainPane = new JPanel();
	
	JLabel distanceDisplay = new JLabel();
	JLabel map = new JLabel();
	JTextField inputDisplay = new JTextField();
	JTextArea heroDisplay = new JTextArea();
	JTextArea explainDisplay = new JTextArea();
	JTextArea battlehistoryDisplay = new JTextArea();
	JTextArea monster1 = new JTextArea();
	JTextArea monster2 = new JTextArea();
	JTextArea monsterking = new JTextArea();
	
	JScrollPane scrollPane = new JScrollPane(battlehistoryDisplay);
	
	Sentence st = new Sentence();
	
	Hero hero = new Hero("ELF HERO");
	Monster mon1 = new Monster("mon1",1);
	Monster mon2,monKing;
	
	int init = 0;
	
	/*
	 * MODE = 0 게임시작 1 몬스터1 2 몬스터2 3몬스터킹 10 게임오버
	 * 
	 */	
	int MODE = 1;
	
	
	Monster monnow;
	
	
	public Windows() {
		
		setSize(800,600);
		setTitle("textRPG");	
		setBackground(Color.WHITE);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		
		heroDisplay.setBorder(new TitledBorder("hero state"));
		heroDisplay.setSize(220, 150);
		heroDisplay.setLocation(10, 125);
		
		explainDisplay.setBorder(new TitledBorder("game explain"));
		explainDisplay.setSize(220, 200);
		explainDisplay.setLocation(10, 270);
		
		distanceDisplay.setBorder(new TitledBorder("distance"));
		distanceDisplay.setSize(220, 120);
		distanceDisplay.setLocation(10, 10);
		
		monster1.setBorder(new TitledBorder("monster1"));
		monster1.setSize(120, 160);
		monster1.setLocation(430, 10);
		
		monster2.setBorder(new TitledBorder("monster2"));
		monster2.setSize(120, 160);
		monster2.setLocation(550, 10);
		
		monsterking.setBorder(new TitledBorder("monsterking"));
		monsterking.setSize(120, 160);
		monsterking.setLocation(670, 10);
		
		map.setBorder(new TitledBorder("MAP"));
		map.setSize(350, 300);
		map.setLocation(430, 170);
		
		
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
		inputDisplay.setLocation(10, 470);
		inputDisplay.addKeyListener(this);
			
		
		mainPane.setBorder(new TitledBorder("mainP"));
		mainPane.setLayout(null);
		mainPane.setLocation(0, 0);
		
		
		mainPane.add(distanceDisplay);
		mainPane.add(monster1);
		mainPane.add(monster2);
		mainPane.add(monsterking);
		mainPane.add(heroDisplay);
		mainPane.add(explainDisplay);
		mainPane.add(scrollPane);
		mainPane.add(inputDisplay);
		mainPane.add(map);
		
		getContentPane().add(mainPane, null);
		
		setVisible(true);
		
		inputDisplay.requestFocus();
		
		monnow = mon1;
		
		stateView(init);
		
		init = 1;
		
		explainDisplay.append(Sentence.EX_1);
		
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//게임오버 아닐때 이벤트발생
		if(MODE != 10) {
		
			int keyN = e.getKeyCode();
			System.out.println(keyN);	
			
			
			//게임초기화
			if(MODE == 0) {

				
			//게임중 키이벤트구현부	
			}else {
				
				if(keyN == 37 || keyN == 38 || keyN == 39 || keyN == 40) {
					String target = hero.move(keyN);
					String point = "영웅이 " + target + " 으로 이동했습니다.\n" + "영웅 위치 X : " + hero.getX() + " Y : " + hero.getY();
					
					battlehistoryDisplay.append(point);
				}
				
			}	
			
			
		}
	}
	
	

	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//상태창 컨트롤
	public void stateView(int init) {

	}
	
	//화면그리기
	public void showDisplay(Hero hero,Monster nowmon) {
				

	}
	
	//영웅, 몬스터의 HP 상태에 따른 이벤트
	public void healthchk() {
				
	}
	
	//배틀이력 저장
	public void save() {

	}
	
	//몬스터 상태창
	public void monstate() {

	}
	
	
}
