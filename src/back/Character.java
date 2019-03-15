package back;

public class Character {
	
	private String NAME;
	private int LEVEL;
	private int MaxHP;
	private int HP;
	private int Attack;
	private int X;
	private int Y;
	
	public Character(String name, int level, int hp, int attack, int x, int y) {
		this.NAME = name;
		this.LEVEL = level;
		this.HP = hp;
		this.Attack = attack;
		this.X = x;
		this.Y = y;
	}
	
	public int distance(Character hero, Character monster) {
		int hx = hero.getX();
		int hy = hero.getY();
		int mx = monster.getX();
		int my = monster.getY();
		
		int dx = Math.abs(hx - mx);
		int dy = Math.abs(hy - my);
		
		return dx + dy;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getLEVEL() {
		return LEVEL;
	}

	public void setLEVEL(int lEVEL) {
		LEVEL = lEVEL;
	}

	public int getMaxHP() {
		return MaxHP;
	}

	public void setMaxHP(int maxHP) {
		MaxHP = maxHP;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getAttack() {
		return Attack;
	}

	public void setAttack(int attack) {
		Attack = attack;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
	
}
