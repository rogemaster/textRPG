package handler;

import java.awt.event.KeyListener;

import front.View;
import main.GameStart;

public class KeyEvent implements KeyListener{
	View front;
	
	public KeyEvent(View view) {
		front = view;
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		System.out.println("key = " + key);
		String name = "";
		// 이름 입력 게임 시작
		if(front.MODE == 0 && key == 10) {
			name = front.inputDisplay.getText();
			front.gs.back.init(name);
			front.MODE = 1;
		}
		
		System.out.println("MODE = " + front.MODE);
		
		// 게임 진행
		if(front.MODE == 1 && (key == 37 || key == 38 || key == 39 || key == 40)) {
			front.gs.back.moveHistory(key);
			front.gs.back.showDisplay();
		}
		
	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
