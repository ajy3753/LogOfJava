package logOfJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battle {
	// 기본
	private Scanner sc = new Scanner(System.in);
	private MonsterController mc = new MonsterController();
	private Player player;
	private List enemyList = new ArrayList();
	
	// battle용
	private int turn;
	private int dice;
	private int choice;
	private String battleOn = "OFF";
	
	// 기본 생성자
	public Battle() {}
	
	public Battle(Player player) {
		this.player = player;
		int stage = new Game().getStage();
		if(stage < 15) {
			enemyList = mc.mobBattle(player);
		}
		else {
			enemyList = mc.bossBattle(player);
		}
		this.turn = 1;
		this.battleOn = "ON";
	}
	
	// 전투 시작
	public void battleStart() {
		System.out.println("▷" + turn + "번째 턴");
		System.out.println("▷ 나의 차례 : ");
		
		System.out.println("\n============ 적 정보 ============");
		
		System.out.println("[1. 공격한다]");
		System.out.println("[2. 아이템을 사용한다]");
		System.out.println("[3. 체력을 회복한다]");
		System.out.println("[4. 도망친다]");
		
		System.out.print("▶ 행동 선택 : ");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1 :
			break;
		case 2:
			break;
		}
	}
	
	// 공격력 계산 (플레이어)
	public double playerAttack() {
		// 치명타 판정 : 행운% 판정 성공 > 추가 다이스
		// 공격력 : {(근력 * 1.5) + (지능 * 1.5)} * (다이스 * 0.5)
		int crit = (int)(Math.random() * 100 + 1);
		
		if(crit <= player.getLUCK()) {
			System.out.println("▷ 치명타!");
			dice = (int)(Math.random() * 12 + 7);
		}
		else {
			dice = (int)(Math.random() * 6 + 1);
		}
		
		return ((player.getATK() * 1.5) + (player.getINT() * 1.5) * (dice * 0.5));
	}

	// getter, setter
	public String getBattleOn() {
		return battleOn;
	}

	public void setBattleOn(String battleOn) {
		this.battleOn = battleOn;
	}
}
