package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import front.View;

public class BtnEvent implements ActionListener {
	View front;
	
	public BtnEvent(View view) {
		front = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String com = e.getActionCommand();
		System.out.println(com);
		
		switch(com) {
		// 재시작
			case "RE" :
				front.explainDisplay.setText(front.ment.MENT1);
				front.MODE = 0;
				front.battlehistoryDisplay.setText("");
				front.distanceDisplay.setText("");
				front.heroDisplay.setText("");
				front.monster1.setText("");
				front.monster2.setText("");
				front.monsterKing.setText("");
				front.mapDisplay.setText("");
				front.inputDisplay.setEnabled(true);
				front.rePlay.setEnabled(false);
				
				break;
			
			// 다음
			case "NE" :
				int level = front.gs.back.levelUp() + 1;
				System.out.println("level = " + level);
				front.gs.back.stage(level);
				front.explainDisplay.setText(front.ment.EXPL);
				
				if(level == 2) {
					front.monster1.setText("처치 성공!!!");
				}else if(level == 3) {
					front.monster2.setText("처치 성공!!!");
				}else if(level == 4) {
					front.monsterKing.setText("처치 성공!!!");
					front.explainDisplay.setText(front.ment.END);
					front.inputDisplay.setEnabled(false);
					front.next.setEnabled(false);
					front.rePlay.setEnabled(true);
				}
				
				front.inputDisplay.setEnabled(true);
				front.next.setEnabled(false);
				
				break;
		}
	}
}
