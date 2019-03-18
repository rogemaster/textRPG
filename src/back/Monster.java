package back;

public class Monster extends Character {

	private int MS_attackDistance = 2;
	
	public Monster(String name, int level) {
		super(name, level, (int)(70 * level), (int)(4 * level), 15, 2);
		// TODO Auto-generated constructor stub
	}
	
	//몬스터 공격 / 공격성공 1 / 히어로사망 2 / 공격실패 0
	public int MS_attack(Character real) {
		int result = 0;
		int dist = distance(this, real);
		
		if(dist <= MS_attackDistance) {
			int hp = real.getHP();
			hp = hp - this.getAttack();
			
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
	
	// 몬스터 오토무브
	public void autoMove() {
		int xy = (int)(Math.random() * 2) + 1;
		int sign = (int)(Math.random() * 2) + 1;
		int move = (int)(Math.random() * 2) + 1;
		
		// 1 = x | + | 1 // 2 = y | - | 2
		if(xy == 1) {
			if(sign == 1 && move == 1 && getX() < 30) {
				setX(getX() + 1);
			}else if(sign == 1 && move == 2 && getX() < 29) {
				setX(getX() + 2);
			}else if(sign == 2 && move == 1 && getX() > 1) {
				setX(getX() - 1);
			}else if(sign == 2 && move == 2 && getX() > 2) {
				setX(getX() - 2);
			}
			
		}else if(xy == 2) {
			if(sign == 1 && move == 1 && getY() > 1) {
				setY(getY() - 1);
			}else if(sign == 1 && move == 2 && getY() > 2) {
				setY(getY() - 2);
			}else if(sign == 2 && move == 1 && getY() < 10) {
				setY(getY() + 1);
			}else if(sign == 2 && move == 2 && getY() < 9) {
				setY(getY() + 2);
			}
		}
	}

	public int getMS_attackDistance() {
		return MS_attackDistance;
	}

	public void setMS_attackDistance(int mS_attackDistance) {
		MS_attackDistance = mS_attackDistance;
	}
	
	
	
}
