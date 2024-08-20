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
	public List mobBattle(Player player) {
		int size = (int)(Math.random() * (g.getStage() / 5 + 1)  + 0);
		List<Monster> mobList = new ArrayList<>(size);
		
		for(int i = 0; i < mobList.size(); i++) {
			int random = (int)(Math.random() * 4 + 0);
			mobList.add(monsterList.get(random));
		}
		
		return mobList;
	}
	
	// 전투 편성 (보스)
	public List bossBattle(Player player) {
		List<Monster> bossList = new ArrayList<>(5);
		bossList.add(monsterList.get(5));
		
		for(int i = 0; i < bossList.size(); i++) {
			int random = (int)(Math.random() * 5 + 0);
			bossList.add(monsterList.get(random));
		}
		
		return bossList;
	}
	
	// 몬스터 스탯 반환
	
	// 전투 종료 (초기화)
}
