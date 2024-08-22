package logOfJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battle extends GameController {
	// 기본
	private Scanner sc = new Scanner(System.in);
	private MonsterController mc;
	private Player player;
	private List enemyList = new ArrayList();
	
	// battle용
	private int turn;
	private int dice;
	private int choice;
	private boolean battleOn = false;
	private String result;
	
	// 기본 생성자
	public Battle() {}
	
	public Battle(Player player, int stg) {
		this.mc = new MonsterController();
		this.player = player;
		int stage = stg;
		if(stage < 15) {
			enemyList = mc.mobBattle(stg);
		}
		else {
			enemyList = mc.bossBattle(stg);
		}
		this.turn = 1;
		this.battleOn = true;
	}
	
	// 적 정보 출력
	public void enemyPrint() {
		for(int i = 0; i < enemyList.size(); i++) {
			System.out.println(mc.monsterStatReturn(enemyList.get(i), i + 1));
		}
		System.out.println();
	}
	
	// 전투 커맨드 선택
	public void battleSelect() {
		System.out.println("[1. 공격한다]");
		System.out.println("[2. 아이템을 사용한다]");
		System.out.println("[3. 체력을 회복한다]");
		System.out.println("[4. 도망친다]");
		
		System.out.print("▶ 행동 선택 : ");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1 :
			playerAttack();
			return;
		case 2:
			playerItem();
			return;
		default :
			int maxHP = player.getJob().getJobHP();
			if(player.getHP() == maxHP) {
				System.out.println("\n▷ 이미 HP가 가득찬 상태입니다.\n");
				break;
			}
			else if((player.getHP() + 10) > maxHP) {
				System.out.println("\n▷ HP가 전부 회복되었습니다.\n");
				player.setHP(maxHP);
			}
			else {
				System.out.println("\n▷ HP가 10 회복되었습니다.\n");
				player.setHP(player.getHP() + 10);
			}
			enemyAttack();
			break;
		}
	}
	
	// 행동 1 - 공격 (플레이어 턴)
	public void playerAttack() {
		// 플레이어 공격
		System.out.println("\n▷ 공격 대상을 선택하세요.");
		enemyPrint();
		
		System.out.print("▶ 대상 선택 (숫자 입력) : ");
		int attackEnemy = sc.nextInt() - 1;
		sc.nextLine();
		
		int enemyDEF = mc.monsterDefendReturn(enemyList.get(attackEnemy));
		double attackPower = playerAttackPower(enemyDEF);
		String enemyName = mc.monsterNameReturn(enemyList.get(attackEnemy));
		
		System.out.println("▷ " + enemyName + "에게 " + attackPower + "의 공격!");
		System.out.print("▷ " + enemyName + "의 HP가 " + mc.monsterHPReturn(enemyList.get(attackEnemy)) + "에서 ");
		
		double enemyHP = mc.monsterHPDown(enemyList.get(attackEnemy), attackPower);
		
		if(enemyHP <= 0) {
			System.out.println("0으로 줄어듭니다!");
			System.out.println("▷ " + enemyName + " 이(가) 쓰러졌습니다!\n");
			enemyList.remove(attackEnemy);
			if(enemyList.size() == 0) {
				System.out.println("▷ 모든 적을 무찔렀습니다!");
				this.result = "WIN";
				battleOn = false;
				return;
			}
			enemyAttack();
		}
		else {
			System.out.println(enemyHP + "으로 줄어듭니다!\n");
			enemyAttack();
		}
	}
	
	// 행동 1.5 - 공격 (몬스터 턴)
	public void enemyAttack() {
		// 몬스터 공격
		int random = (int)(Math.random() * (enemyList.size()) + 0);
		String enemyName = mc.monsterNameReturn(enemyList.get(random));
		int monsterAttack = mc.monsterAttack(enemyList.get(random));
		
		int damage = player.getHP() - monsterAttack;
		System.out.println("▷ " + enemyName + "의 공격!");
		System.out.println("▷ 플레이어가 " + monsterAttack + "의 대미지를 받았습니다!");
		System.out.print("▷ 플레이어의 HP가 " + player.getHP() + "에서 ");
		player.setHP(damage);
				
		if(damage <= 0) {
			System.out.println("0으로 줄어듭니다!");
			System.out.println("▷ 눈 앞이 깜깜해집니다...");
			this.result = "LOSE";
			battleOn = false;
			return;
		}
		else {
			System.out.println(damage + "로 줄어듭니다!");
		}
		
		// 다음 턴 진행
		System.out.print("\n▶ 다음 턴 진행 (아무 키나 누르세요) : ");
		sc.nextLine();
				
		turn++;
	}
	
	// 행동 2 - 아이템 사용
	public void playerItem() {
		// 미구현,,,
	}
	
	// 공격력 계산 (플레이어)
	public double playerAttackPower(int enemyDEF) {
		// 치명타 판정 : 행운% 판정 성공 > 추가 다이스
		// 공격력 : {(근력 * 1.5) + (지능 * 1.5)} * (다이스 * 0.5)
		int crit = (int)(Math.random() * 100 + 1);
			
		if(crit <= player.getLUCK()) {
			System.out.println("\n▷ 치명타!");
			dice = (int)(Math.random() * 12 + 7);
		}
		else {
			System.out.println();
			dice = (int)(Math.random() * 6 + 1);
		}
		
		return ((player.getATK() * 1.5) + (player.getINT() * 1.5) * (dice * 0.5)) - enemyDEF;
	}

	// getter, setter
	public List getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(List enemyList) {
		this.enemyList = enemyList;
	}
	
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public boolean isBattleOn() {
		return battleOn;
	}

	public void setBattleOn(boolean battleOn) {
		this.battleOn = battleOn;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
