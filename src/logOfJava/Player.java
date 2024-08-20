package logOfJava;

import java.util.ArrayList;
import java.util.List;

public class Player {
	// Player 변수
	private String playerName;
	private Job job;
	private int HP;
	private int ATK;
	private int INT;
	private int LUCK;
	private int BONUS;
	private List<String> itemList = new ArrayList<>(5);
	
	// 기본 생성자
	public Player() {}
	
	// 캐릭터 생성
	public Player(String playerName, Job job) {
		this.playerName = playerName;
		this.job = job;
		HP = job.getJobHP();
		ATK = job.getJobATK();
		INT = job.getJobINT();
		LUCK = job.getJobLUCK();
		BONUS = job.getJobBONUS();
		itemList.add("시작의 주먹밥");
	}
	
	// 캐릭터 불러오기
	public Player(String playerName, Job job, int HP, int ATK, int INT, int LUCK, int BONUS, List itemList) {
		this.playerName = playerName;
		this.job = job;
		this.HP = HP;
		this.ATK = ATK;
		this.INT = INT;
		this.BONUS = BONUS;
		this.itemList = itemList;
	}

	// getter, setter
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		HP = HP;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int ATK) {
		ATK = ATK;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int INT) {
		INT = INT;
	}

	public int getLUCK() {
		return LUCK;
	}

	public void setLUCK(int LUCK) {
		LUCK = LUCK;
	}

	public int getBONUS() {
		return BONUS;
	}

	public void setBONUS(int BONUS) {
		BONUS = BONUS;
	}

	public List getItemList() {
		return itemList;
	}

	public void setItemList(List itemList) {
		this.itemList = itemList;
	}
}
