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
		hero = new Hero(name, 1);
		mon = new Monster("ZOMBIE", 1);
		heroState();
		monsterState(1);
		showDisplay();
		distance();
	}
	
	// 레벨 추출(버튼 이벤트 값 전달용)
	public int levelUp() {
		int level = hero.getLEVEL();
		System.out.println("Lv Check = " + level);
		return level;
	}
	
	// 레벨업별 셋팅(버튼 이벤트 파라미터)
	public void stage(int step) {
		switch(step) {
			case 2 :
				System.out.println("stage 2");
				hero = new Hero(hero.getNAME(), step);
				mon = new Monster("Guwool", step);
				heroState();
				monsterState(step);
				showDisplay();
				gs.front.battlehistoryDisplay.append("2단계 몬스터가 나타났습니다.\n");
				break;
				
			case 3 :
				System.out.println("stage 3");
				hero.setLEVEL(step);
				hero = new Hero(hero.getNAME(), step);
				mon = new Monster("Skeleton", step);
				heroState();
				monsterState(step);
				showDisplay();
				gs.front.battlehistoryDisplay.append("마지막 몬스터가 나타났습니다.\n");
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
					map += "☆";
				}else if(x == mx && y == my) {
					map += "◎";
				}else {
					map+= "▩";
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
												+ "Lv ▷▷ " + hero.getLEVEL() + "\n"
												+ "HP ▷▷ " + hero.getHP() + "\n"
												+ "원거리 공격력 ▷▷ " + hero.getHA_heroAttack() + "\n"
												+ "근거리 공격력 ▷▷ " + hero.getHS_heroAttack() + "\n"
												+ "원거리공격 사정거리 ▷▷ " + hero.getHA_heroDistance() + "\n"
												+ "근거리공격 사정거리 ▷▷ " + hero.getHS_heroDistance();
		
		gs.front.heroDisplay.setText(heroState);
	}
	
	// 몬스터 능력치 구현
	public void monsterState(int level) {
		
		switch(level) {
			case 1 :
				String monState = "이름 ▶▶ " + mon.getNAME() + "\n"
						+ "HP ▶▶ " + mon.getHP() + "\n"
						+ "공격력 ▶▶ " + mon.getAttack() + "\n"
						+ "사정거리 ▶▶ " + mon.getMS_attackDistance();
				
				gs.front.monster1.setText(monState);
				break;
				
			case 2 :
				String mon2State = "이름 ▶▶ " + mon.getNAME() + "\n"
						+ "HP ▶▶ " + mon.getHP() + "\n"
						+ "공격력 ▶▶ " + mon.getAttack() + "\n"
						+ "사정거리 ▶▶ " + mon.getMS_attackDistance();
				
				gs.front.monster2.setText(mon2State);
				break;
				
			case 3 :
				String monKingState = "이름 ▶▶ " + mon.getNAME() + "\n"
						+ "HP ▶▶ " + mon.getHP() + "\n"
						+ "공격력 ▶▶ " + mon.getAttack() + "\n"
						+ "사정거리 ▶▶ " + mon.getMS_attackDistance();
				
				gs.front.monsterKing.setText(monKingState);
				break;
		}
	}
	
	public void distance() {
		int hx = hero.getX();
		int hy = hero.getY();
		int mx = mon.getX();
		int my =mon.getY();
		int dx = Math.abs(hx - mx);
		int dy = Math.abs(hy - my);
		String dis = Integer.toString(dx + dy);
		
		gs.front.distanceDisplay.setText("거리 :: " + dis);
		
	}
	
	// 히어로 이동 & 히스토리
	public void heroMove(int dis) {
		String move_msg = hero.move(dis);
		gs.front.battlehistoryDisplay.append(move_msg + "\n");
	}
	
	// 몬스터 자동 이동
	public void monMove() {
		mon.autoMove();
	}
	
	//  히어로 공격 & 히스토리
	public void heroAttackHistory(int key) {
		String attack_msg = "";
		int result;
		
		if(key == 65) {
			result = hero.HA_heroAttack(mon);
			if(result == 1) {
				monsterState(mon.getLEVEL());
				attack_msg = hero.getHA_heroAttack() + " 만큼 공격 성공" + "\n";
				
			}else if(result == 2) {
				monsterState(mon.getLEVEL());
				attack_msg = mon.getNAME() + " 처치 성공" + "\n";
				gs.front.inputDisplay.setEnabled(false);
				gs.front.next.setEnabled(true);
				
			}else {
				attack_msg = "공격 실패" + "\n";
			}
			
		}else if(key == 83) {
			result = hero.HS_heroAttack(mon);
			if(result == 1) {
				monsterState(mon.getLEVEL());
				attack_msg = hero.getHS_heroAttack() + " 만큼 공격 성공" + "\n";
				
			}else if(result == 2) {
				monsterState(mon.getLEVEL());
				attack_msg = mon.getNAME() + " 처치 성공" + "\n";
				gs.front.inputDisplay.setEnabled(false);
				gs.front.next.setEnabled(true);
				gs.front.explainDisplay.setText(gs.front.ment.MONDIE);
				
			}else {
				attack_msg = "공격 실패" + "\n";
			}
		}
		
		gs.front.battlehistoryDisplay.append(attack_msg);
	}
	
	
	// 몬스터 공격 & 히스토리
	public void monAttackHistory() {
		String attack_msg = "";
		int result = mon.MS_attack(hero);
		
		if(result == 1) {
			attack_msg = mon.getAttack() + " 만큼 피해" + "\n";
			heroState();
		}else if(result == 2) {
			attack_msg = mon.getNAME() + "에게 사망" + "\n"
								+ "◆◆◆ G.A.M.E.O.V.E.R ◆◆◆" + "\n";
			heroState();
			gs.front.inputDisplay.setEnabled(false);
			gs.front.rePlay.setEnabled(true);
			gs.front.explainDisplay.setText(gs.front.ment.HERODIE);
		}
		
		gs.front.battlehistoryDisplay.append(attack_msg);
	}

}
