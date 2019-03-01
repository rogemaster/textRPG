package textRPGt2.charc;


public class Monster extends Character{
	
	private int attackDistance;
	
	public Monster(String name, int level) {
		
		super(name, (int)(30 * 1.6 * level), level, (int)(6 * 1.6 * level), 15, 2);
		// TODO Auto-generated constructor stub
		this.setAttackDistance(2);
		
	}
	
	// xy가 1이면 x축 2면 y축
	// sign이 1이면 + 2면 -
	// move가 1이면 1이동 2면 2이동
	public void automove(int input) {
		int xy = (int)(Math.random() * 2) + 1;
		System.out.println("xy = " + xy);
		int sign = (int)(Math.random() * 2) + 1;
		System.out.println("sign = " + sign);
		int move = (int)(Math.random() * 2) + 1;
		System.out.println("move = " + move);
		
		// x축으로 이동 
		if(xy == 1) {
			
			// sign 1이면 +  
			if(sign == 1) {
				
				// move 1이면 1칸
				if(move == 1) {
					int x = this.getX();
					x = x + move;
					this.setX(x);
					
				// 2이면 2칸	
				}else {
					int y = this.getY();
					y = y + move;
					this.setY(y);
				}
				
			// sign 2이면 -	
			}else {
				
				// move 1이면 1
				
				
				
				
			}
			
		// y축으로 이동
		}else {
			
			
			
		}
		
		
	}
	
	public int attack(Character real) {
		// TODO Auto-generated method stub
		System.out.println("몬공");
		int result = 0;
		int dist = distance(this, real);
		
		if(dist <= attackDistance) {
			System.out.println("몬공성공");
			int hp = real.getHp();
			hp = hp - this.getAttack_p();	
			if(hp <= 0) hp = 0;
			real.setHp(hp);
			
			result = 1;
		}
		
		return result;
		
	}



	public int getAttackDistance() {
		return attackDistance;
	}

	public void setAttackDistance(int attackDistance) {
		this.attackDistance = attackDistance;
	}
}
