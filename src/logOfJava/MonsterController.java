package logOfJava;

import java.util.ArrayList;
import java.util.List;

public class MonsterController {
	private Game g = new Game();
	private List<Monster> monsterList = new ArrayList<>();
	
	// 기본 생성자
	public MonsterController() {
		// 일반몹
		monsterList.add(new Monster("슬라임", 55, 2, 2, 5, "일반"));
		monsterList.add(new Monster("걷는 버섯", 60, 3, 10, 5, "일반"));
		monsterList.add(new Monster("고블린", 100, 5, 5, 10, "일반"));
		monsterList.add(new Monster("오크", 130, 10, 10, 15, "일반"));
		monsterList.add(new Monster("와이번", 100, 15, 5, 10, "일반"));
		
		// 보스몹
		monsterList.add(new Monster("레드 드래곤", 250, 20, 10, 20, "보스"));
	}
	
	// 전투 편성 (일반)
	public List mobBattle(int stage) {
		int size = (int)(Math.random() * (stage / 3 + 1)  + 1);
		int random = (int)(Math.random() * 4 + 0);
		
		List<Monster> mobList = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			mobList.add(monsterList.get(random++));
			if(random > 4) {
				random = 0;
			}
		}
		
		return mobList;
	}
	
	// 전투 편성 (보스)
	public List bossBattle(int stage) {
		List<Monster> bossList = new ArrayList<>(5);
		int random = (int)(Math.random() * 4 + 0);
		
		bossList.add(monsterList.get(5));
		for(int i = 0; i < 5; i++) {
			bossList.add(monsterList.get(random++));
			if(random > 4) {
				random = 0;
			}
		}
		
		return bossList;
	}
	
	// 인덱스 정보 찾아서 반환
	public int monsterIndexReturn(Object enemy) {
		for(int i = 0; i < monsterList.size(); i++) {
			if(enemy.equals(monsterList.get(i))) {
				return i;
			}
		}
		return 0;
	}
	
	// 몬스터 정보 반환 (기본)
	public String monsterStatReturn(Object enemy, int seq) {
		int index = monsterIndexReturn(enemy);
		String name = monsterList.get(index).getMonsterName();
		double HP = monsterList.get(index).getMonsterHP();
		return "< " + seq + " > " + name + " ( HP : " + HP + " )";
	}
	
	// 몬스터 이름 반환
	public String monsterNameReturn(Object enemy){
		int index = monsterIndexReturn(enemy);
		return monsterList.get(index).getMonsterName();
	}
	
	// 몬스터 체력 반환
	public double monsterHPReturn(Object enemy) {
		int index = monsterIndexReturn(enemy);
		return monsterList.get(index).getMonsterHP();
	}
	
	// 몬스터 방어력 반환
	public int monsterDefendReturn(Object enemy) {
		int index = monsterIndexReturn(enemy);
		return monsterList.get(index).getMonsterDEF();
	}
	
	// 공격 판정 (플레이어 > 몬스터)
	public double monsterHPDown(Object enemy, double attackPower) {
		int index = monsterIndexReturn(enemy);
		
		double HPDown = monsterList.get(index).getMonsterHP() - attackPower;
		monsterList.get(index).setMonsterHP(HPDown);
		
		return monsterList.get(index).getMonsterHP();
	}
	
	// 공격 판정 (몬스터 > 플레이어)
	public int monsterAttack(Object enemy) {
		return monsterList.get(monsterIndexReturn(enemy)).getMonsterATK();
	}
	
	// getter, setter
	public List<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(List<Monster> monsterList) {
		this.monsterList = monsterList;
	}
}
