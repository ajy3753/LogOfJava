package logOfJava;

public class Monster {
	// Monster 변수
	private String monsterName;
	private int monsterHP;
	private int monsterATK;
	private int monsterDEF;
	private int monsterCRI;
	private String monsterType;
	
	// 기본 생성자
	public Monster() {}
	
	public Monster(String monsterName, int monsterHP, int monsterATK, int monsterDEF, int monsterCRI, String monsterType) {
		this.monsterName = monsterName;
		this.monsterHP = monsterHP;
		this.monsterATK = monsterATK;
		this.monsterDEF = monsterDEF;
		this.monsterCRI = monsterCRI;
		this.monsterType = monsterType;
	}

	// getter, setter
	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	
	public int getMonsterHP() {
		return monsterHP;
	}

	public void setMonsterHP(int monsterHP) {
		this.monsterHP = monsterHP;
	}

	public int getMonsterATK() {
		return monsterATK;
	}

	public void setMonsterATK(int monsterATK) {
		this.monsterATK = monsterATK;
	}

	public int getMonsterDEF() {
		return monsterDEF;
	}

	public void setMonsterDEF(int monsterDEF) {
		this.monsterDEF = monsterDEF;
	}

	public int getMonsterCRI() {
		return monsterCRI;
	}

	public void setMonsterCRI(int monsterCRI) {
		this.monsterCRI = monsterCRI;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
}
