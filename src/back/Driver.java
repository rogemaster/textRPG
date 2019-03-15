package back;

import main.GameStart;

public class Driver {
	
	public GameStart gs;
	Hero hero;
	Monster mon;
	
	public Driver(GameStart gameStart) {
		this.gs = gameStart;
	}
	
	// 초기설정(키 이벤트 파라미터)
	public void init(String name) {
		hero = new Hero(name);
		mon = new Monster("ZOMBIE", 1);
		heroState();
		monsterState();
		showDisplay();
	}
	
	// 레벨업별 셋팅(버튼 이벤트 파라미터)
	public void stage(int step) {
		switch(step) {
			case 2:
				hero.setLEVEL(step);
				mon = new Monster("Guwool", step);
				heroState();
				monsterState();
				showDisplay();
				break;
				
			case 3:
				hero.setLEVEL(step);
				mon = new Monster("Skeleton", step);
				heroState();
				monsterState();
				showDisplay();
				break;
		}
	}
	
	// 맵구현
	public void showDisplay() {
		String map = "<html>";
		
		for(int y = 1; y < 11; y++) {
			for(int x = 1; x < 31; x++) {
				int hx = hero.getX();
				int hy = hero.getY();
				int mx = mon.getX();
				int my = mon.getY();
				
				if(x == hx && y == hy) {
					map += "H";
				}else if(x == mx && y == my) {
					map += "M";
				}else {
					map+= "*";
				}
			}
			map += "<br>";
		}
		map += "</html>";
		
		gs.front.mapDisplay.setText(map);
		
	}
	
	// 히어로 능력치 구현
	public void heroState() {
		String heroState = "이름 ▷▷ " +hero.getNAME()  + "\n"
												+ "HP ▷▷ " + hero.getHP() + "\n"
												+ "원거리 공격력 ▷▷ " + hero.getHA_heroAttack() + "\n"
												+ "근거리 공격력 ▷▷ " + hero.getHS_heroAttack() + "\n"
												+ "원거리공격 사정거리 ▷▷ " + hero.getHA_heroDistance() + "\n"
												+ "근거리공격 사정거리 ▷▷ " + hero.getHS_heroDistance();
		
		gs.front.heroDisplay.setText(heroState);
	}
	// 몬스터 능력치 구현
	public void monsterState() {
		String monState = "이름 ▶▶ " + mon.getNAME() + "\n"
												+ "HP ▶▶ " + mon.getHP() + "\n"
												+ "공격력 ▶▶ " + mon.getAttack() + "\n"
												+ "사정거리 ▶▶ " + mon.getMS_attackDistance();
		
		gs.front.monster1.setText(monState);
	}
	
	// 히어로 이동 히스토리 출력
	public void moveHistory(int dis) {
		String move_msg = hero.move(dis);
		mon.autoMove();
		gs.front.battlehistoryDisplay.append(move_msg + "\n");
	}
	
	//  히어로 공격 히스토리 출력
	public void attackHistory(int key) {
		String attack_msg = "";
		int result;
		
		if(key == 65) {
			result = hero.HA_heroAttack(mon);
			if(result == 1) {
				attack_msg = hero.getHA_heroAttack() + " 만큼 공격 성공" + "\n";
				monsterState();
			}else if(result == 2) {
				attack_msg = mon.getNAME() + " 처치 성공" + "\n";
				monsterState();
			}else {
				attack_msg = "공격 실패" + "\n";
			}
			
		}else if(key == 83) {
			result = hero.HS_heroAttack(mon);
			if(result == 1) {
				attack_msg = hero.getHS_heroAttack() + " 만큼 공격 성공" + "\n";
				monsterState();
			}else if(result == 2) {
				attack_msg = mon.getNAME() + " 처치 성공" + "\n";
				monsterState();
			}else {
				attack_msg = "공격 실패" + "\n";
			}
		}
		
		gs.front.battlehistoryDisplay.append(attack_msg);
	}
	
	
	
	
	
	
	
	
	
	
}
