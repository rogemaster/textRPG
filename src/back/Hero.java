package back;

public class Hero extends Character {

	private int HA_heroDistance = 5;	//원
	private int HS_heroDistance = 3;	//근
	private int HA_heroAttack;
	private int HS_heroAttack;
	
	public Hero(String name, int level) {
		super(name, level, (int)(50 * level), (int)(3 * level), 15, 9);
		// TODO Auto-generated constructor stub
		
		HA_heroAttack = super.getAttack();
		HS_heroAttack = super.getAttack() * 2;
	}
	
	//히어로 원거리 공격 / 공격성공 1 / 몬스터사망 2 / 공격실패 0
	public int HA_heroAttack(Character real) {
		int result = 0;
		int dist = distance(this, real);
		
		if(dist <= HS_heroDistance) {
			int hp = real.getHP();
			hp = hp - HA_heroAttack;
			
			if(hp <= 0) {
				hp = 0;
				real.setHP(hp);
				result = 2;
				return result;
			}
			real.setHP(hp);
			result = 1;
		}
		return result;
	}
	
	// 히어로 근거리 공격
	public int HS_heroAttack(Character real) {
		int result = 0;
		int dist = distance(this, real);
		
		if(dist <= HS_heroDistance) {
			int hp = real.getHP();
			hp = hp - HS_heroAttack;
			
			if(hp <= 0) {
				hp = 0;
				result = 2;
				return result;
			}
			real.setHP(hp);
			result = 1;
		}
		return result;
	}
	
	// 이동 메세지 & 이동 좌표 설정
	public String move(int distance) {
		String dir = "";
		
		if(distance == 37 && this.getX() != 1) {
			this.setX(this.getX() - 1);
			dir = "왼쪽 이동";
		}else if(distance == 39 && this.getX() != 30) {
			this.setX(this.getX() + 1);
			dir = "오른쪽 이동";
		}else if(distance == 38 && this.getY() != 1) {
			this.setY(this.getY() - 1);
			dir = "상단 이동";
		}else if(distance == 40 && this.getY() != 10) {
			this.setY(this.getY() + 1);
			dir = "하단 이동";
		}else {
			dir = "이동 불가";
		}
		
		return dir;
	}

	public int getHA_heroDistance() {
		return HA_heroDistance;
	}

	public void setHA_heroDistance(int hA_heroDistance) {
		HA_heroDistance = hA_heroDistance;
	}

	public int getHS_heroDistance() {
		return HS_heroDistance;
	}

	public void setHS_heroDistance(int hS_heroDistance) {
		HS_heroDistance = hS_heroDistance;
	}

	public int getHA_heroAttack() {
		return HA_heroAttack;
	}

	public void setHA_heroAttack(int hA_heroAttack) {
		HA_heroAttack = hA_heroAttack;
	}

	public int getHS_heroAttack() {
		return HS_heroAttack;
	}

	public void setHS_heroAttack(int hS_heroAttack) {
		HS_heroAttack = hS_heroAttack;
	}
	
	

}
