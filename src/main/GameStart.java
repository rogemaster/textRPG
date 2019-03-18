package main;

import back.Driver;
import front.View;

public class GameStart {
	public View front;
	public Driver back;
	
	public GameStart() {
		front = new View(this);
		back = new Driver(this);
		front.setVisible(true);
	}
	
	public static void main(String[] args) {
		GameStart gameStart = new GameStart();
	}
	
}
